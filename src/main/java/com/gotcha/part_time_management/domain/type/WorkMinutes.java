package com.gotcha.part_time_management.domain.type;

/**
 * 労働時間 分で表す
 *
 */
public class WorkMinutes {
    private int value;

    private WorkMinutes(int value) {
        this.value = value;
    }

    public static WorkMinutes ofMinutes(int minutes) {
        if (!validated(minutes)) {
            throw new IllegalArgumentException("不正な労働時間です");
        }
        return new WorkMinutes(minutes);
    }

    private static boolean validated(int value) {
        return value >= 0;
    }

    public int intValue() {
        return value;
    }

    public WorkMinutes add(WorkMinutes other) {
        int sum = this.value + other.value;
        return WorkMinutes.ofMinutes(sum);
    }

    public WorkMinutes minus(WorkMinutes other) {
        int sub = this.value - other.value;
        return WorkMinutes.ofMinutes(sub);
    }
}
