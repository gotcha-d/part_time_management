// パート勤務時間・給与計算アプリケーション

document.addEventListener('DOMContentLoaded', function() {
    // フォーム要素の取得
    const form = document.getElementById('calcForm');
    const clearBtn = document.getElementById('clearBtn');
    const resultsSection = document.getElementById('resultsSection');

    // 入力フィールドの取得
    const startHourInput = document.getElementById('startHour');
    const startMinuteInput = document.getElementById('startMinute');
    const endHourInput = document.getElementById('endHour');
    const endMinuteInput = document.getElementById('endMinute');
    const breakTimeInput = document.getElementById('breakTime');
    const calculationUnitSelect = document.getElementById('calculationUnit');
    const hourlyWageInput = document.getElementById('hourlyWage');

    // 結果表示要素の取得
    const workTimeResult = document.getElementById('workTimeResult');
    const paymentTimeResult = document.getElementById('paymentTimeResult');
    const paymentTimeHoursResult = document.getElementById('paymentTimeHoursResult');
    const dailyPayResult = document.getElementById('dailyPayResult');

    // 計算ボタンのイベントリスナー
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        calculatePartTimeWork();
    });

    // クリアボタンのイベントリスナー
    clearBtn.addEventListener('click', function() {
        clearForm();
    });

    /**
     * 勤務時間と給与を計算する
     */
    function calculatePartTimeWork() {
        // 入力値の取得
        const startHour = parseInt(startHourInput.value) || 0;
        const startMinute = parseInt(startMinuteInput.value) || 0;
        const endHour = parseInt(endHourInput.value) || 0;
        const endMinute = parseInt(endMinuteInput.value) || 0;
        const breakTime = parseInt(breakTimeInput.value) || 0;
        const calculationUnit = parseInt(calculationUnitSelect.value) || 1;
        const hourlyWage = parseInt(hourlyWageInput.value) || 0;
        const roundingMode = document.querySelector('input[name="roundingMode"]:checked').value;

        // バリデーション
        if (!validateInputs(startHour, startMinute, endHour, endMinute, hourlyWage)) {
            return;
        }

        // 開始時刻と終了時刻を分単位に変換
        const startMinutes = startHour * 60 + startMinute;
        let endMinutes = endHour * 60 + endMinute;

        // 終了時刻が開始時刻より早い場合、翌日とみなす
        if (endMinutes < startMinutes) {
            endMinutes += 24 * 60; // 24時間分の分数を追加
        }

        // 労働時間を計算(分単位)
        const totalWorkMinutes = endMinutes - startMinutes;

        // 休憩時間を引いた実労働時間
        const actualWorkMinutes = totalWorkMinutes - breakTime;

        // 給与計算時間を計算(計算単位で丸め)
        const paymentMinutes = applyRounding(actualWorkMinutes, calculationUnit, roundingMode);

        // 日給を計算
        const dailyPay = Math.floor((hourlyWage * paymentMinutes) / 60);

        // 結果を表示
        displayResults(totalWorkMinutes, actualWorkMinutes, paymentMinutes, dailyPay);
    }

    /**
     * 入力値のバリデーション
     */
    function validateInputs(startHour, startMinute, endHour, endMinute, hourlyWage) {
        if (startHour < 0 || startHour > 23) {
            alert('開始時刻の「時」は0〜23の範囲で入力してください。');
            return false;
        }

        if (startMinute < 0 || startMinute > 59) {
            alert('開始時刻の「分」は0〜59の範囲で入力してください。');
            return false;
        }

        if (endHour < 0 || endHour > 23) {
            alert('終了時刻の「時」は0〜23の範囲で入力してください。');
            return false;
        }

        if (endMinute < 0 || endMinute > 59) {
            alert('終了時刻の「分」は0〜59の範囲で入力してください。');
            return false;
        }

        if (hourlyWage < 0) {
            alert('時給は0以上の値を入力してください。');
            return false;
        }

        return true;
    }

    /**
     * 計算単位に基づいた丸め処理
     */
    function applyRounding(minutes, unit, mode) {
        const quotient = Math.floor(minutes / unit);
        const remainder = minutes % unit;

        let result;
        switch (mode) {
            case 'floor': // 切り捨て
                result = quotient * unit;
                break;
            case 'ceil': // 切り上げ
                result = remainder > 0 ? (quotient + 1) * unit : quotient * unit;
                break;
            case 'round': // 四捨五入
                result = remainder >= unit / 2 ? (quotient + 1) * unit : quotient * unit;
                break;
            default:
                result = minutes;
        }

        return result;
    }

    /**
     * 分を「〇時間〇〇分」形式に変換
     */
    function formatMinutesToHoursAndMinutes(minutes) {
        const hours = Math.floor(minutes / 60);
        const mins = minutes % 60;
        return `${hours}時間${mins.toString().padStart(2, '0')}分`;
    }

    /**
     * 分を小数点形式の時間に変換
     */
    function formatMinutesToDecimalHours(minutes) {
        const hours = minutes / 60;
        return hours.toFixed(2);
    }

    /**
     * 数値を3桁カンマ区切りでフォーマット
     */
    function formatNumber(num) {
        return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    }

    /**
     * 結果を表示
     */
    function displayResults(totalWorkMinutes, actualWorkMinutes, paymentMinutes, dailyPay) {
        // 労働時間の表示
        workTimeResult.textContent = formatMinutesToHoursAndMinutes(actualWorkMinutes);

        // 給与計算時間の表示
        paymentTimeResult.textContent = formatMinutesToHoursAndMinutes(paymentMinutes);
        paymentTimeHoursResult.textContent = formatMinutesToDecimalHours(paymentMinutes);

        // 日給の表示
        dailyPayResult.textContent = formatNumber(dailyPay);

        // 結果セクションを表示
        resultsSection.classList.remove('hidden');

        // 結果セクションまでスムーズにスクロール
        resultsSection.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
    }

    /**
     * フォームをクリア
     */
    function clearForm() {
        startHourInput.value = '';
        startMinuteInput.value = '';
        endHourInput.value = '';
        endMinuteInput.value = '';
        breakTimeInput.value = '';
        hourlyWageInput.value = '';
        calculationUnitSelect.value = '1';
        document.querySelector('input[name="roundingMode"][value="floor"]').checked = true;

        // 結果セクションを非表示
        resultsSection.classList.add('hidden');

        // 最初の入力フィールドにフォーカス
        startHourInput.focus();
    }

    /**
     * Enterキーで次のフィールドに移動
     */
    const inputs = [
        startHourInput,
        startMinuteInput,
        endHourInput,
        endMinuteInput,
        breakTimeInput,
        calculationUnitSelect,
        hourlyWageInput
    ];

    inputs.forEach((input, index) => {
        input.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                e.preventDefault();
                if (index < inputs.length - 1) {
                    inputs[index + 1].focus();
                } else {
                    form.dispatchEvent(new Event('submit'));
                }
            }
        });
    });

    // 初期フォーカス
    startHourInput.focus();
});