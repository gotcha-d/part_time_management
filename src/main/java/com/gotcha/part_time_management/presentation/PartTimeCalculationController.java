package com.gotcha.part_time_management.presentation;

import com.gotcha.part_time_management.RequestAttendanceForm;
import com.gotcha.part_time_management.Result;
import com.gotcha.part_time_management.domain.service.DailyPayCalculator;
import com.gotcha.part_time_management.domain.type.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartTimeCalculationController {

    @PostMapping("/calculate")
    public Result calculate(@RequestBody RequestAttendanceForm form) {
        // フォームから値オブジェクトを生成
        Hour startHour = new Hour(form.getStartHour());
        Minute startMinute = new Minute(form.getStartMinute());
        TimeOfDay startTime = new TimeOfDay(startHour, startMinute);

        Hour endHour = new Hour(form.getEndHour());
        Minute endMinute = new Minute(form.getEndMinute());
        TimeOfDay endTime = new TimeOfDay(endHour, endMinute);

        // 勤務時間範囲を作成
        WorkRange workRange = new WorkRange(startTime, endTime);

        // 労働時間を計算（分単位）
        WorkMinutes totalWorkMinutes = workRange.toWorkTime();

        // 時給を作成
        Amount hourlyWageAmount = new Amount(form.getHourlyWage());
        HourlyWage hourlyWage = new HourlyWage(hourlyWageAmount);

        // 日給計算サービスを使用
        DailyPayCalculator calculator = new DailyPayCalculator(hourlyWage, workRange);
        Amount dailyPay = calculator.calc();

        // 結果を返す
        Result result = new Result();
        result.setWorkTime(totalWorkMinutes.intValue());
        result.setAmount(dailyPay.intValue());

        return result;
    }
}