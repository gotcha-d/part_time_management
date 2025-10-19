package com.gotcha.part_time_management.domain.type;

/**
 * 勤怠
 */
public class Attendance {

    WorkRange workRange;
    HourlyWage hourlyWage;

    Attendance(WorkRange workRange,HourlyWage hourlyWage) {
        this.workRange = workRange;
        this.hourlyWage = hourlyWage;
    }

    public Amount payroll() {
        WorkMinutes workMinutes = workRange.toWorkTime();
        return hourlyWage.amountFor(workMinutes);
    }
}
