package com.gotcha.part_time_management.domain.type;

/**
 * 時刻
 */
public class TimeOfDay {
    Hour hour;
    Minute minute;

    TimeOfDay(Hour hour, Minute minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format("%s時%s分", hour.toString(), minute);
    }

    public MinutesOfDay toMinuteOfDay() {
        int minutes = hour.intValue() * 60 + minute.intValue();
        return new MinutesOfDay(minutes);
    }
}
