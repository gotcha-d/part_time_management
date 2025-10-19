package com.gotcha.part_time_management.domain.type;

/**
 * 0:00 を起点にした分数
 */
public class MinutesOfDay {

    public static final int MAX = 1440;
    private int value;

    MinutesOfDay(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

}
