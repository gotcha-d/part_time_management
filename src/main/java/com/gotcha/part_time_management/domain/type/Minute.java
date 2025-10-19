package com.gotcha.part_time_management.domain.type;

/**
 * 時刻_分
 *
 */
public class Minute {
    int value;

    Minute(int value) {
        // TODO: バリデーション
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Minute other = (Minute) obj;
        return this.value == other.value;
    }

    public int intValue() {
        return value;
    }
}
