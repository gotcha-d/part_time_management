package com.gotcha.part_time_management.domain.type;

public class TimeRecord {
    HourTime start;
    HourTime end;

    public TimeRecord(HourTime start, HourTime end) {
        this.start = start;
        this.end = end;
    }

}
