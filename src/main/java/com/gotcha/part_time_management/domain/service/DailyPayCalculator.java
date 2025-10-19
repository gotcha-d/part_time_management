package com.gotcha.part_time_management.domain.service;

import com.gotcha.part_time_management.RequestAttendanceForm;
import com.gotcha.part_time_management.domain.type.*;

/**
 * 日給計算
 * ドメインサービス層
 * - 値オブジェクトを協調し、「日給を計算する」というビジネスルールそのものを実現する。
 * - 異なる二つの関心ごとを協調させる
 *   - 労働時間の算出
 *   - 労働時間をもとに日給の算出
 */
public class DailyPayCalculator {

    WorkRange workRange; // TODO: 本来は勤怠記録とすべき。まずはミニマムに勤務期間から日給を算出する
    HourlyWage hourlyWage;

    DailyPayCalculator(HourlyWage hourlyWage, WorkRange workRange) {
        this.hourlyWage = hourlyWage;
        this.workRange = workRange;
    }

    public Amount calc() {
        WorkMinutes workMinutes = workRange.toWorkTime();
        return hourlyWage.amountFor(workMinutes);
    }
}
