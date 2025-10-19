package com.gotcha.part_time_management;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestAttendanceForm implements Serializable {
    private int StartHour;
    private int StartMinute;
    private int EndHour;
    private int EndMinute;
    private int hourlyWage;
}
