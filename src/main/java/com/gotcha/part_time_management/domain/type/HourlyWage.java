package com.gotcha.part_time_management.domain.type;

/**
 * 時給
 */
public class HourlyWage {

    Amount amount;

    public HourlyWage(Amount amount) {
        this.amount = amount;
    }

    public Amount amountFor(WorkMinutes workMinutes) {
        Amount wagePerMinute = amount.divide(60);
        return wagePerMinute.multiply(workMinutes.intValue());
    }
}
