package com.gotcha.part_time_management.domain.type;

/**
 * 時刻_時間
 *
 * java16以降では値オブジェクトはrecordでも代用ができるが、学習のためclassとする
 */
public class Hour {

    public final int MIN = 0;
    public final int MAX = 47;

    private final int value;

    Hour(int value) {
        if (!validate(value)) {
            throw new IllegalArgumentException("時刻_時間の値が不正です。");
        }
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    private boolean validate(int value) {
        return (MIN <= value || value <= MAX);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 同一インスタンスチェック
        if (this == obj) {
            return true;
        }

        // 2. nullチェックと型チェック
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3. フィールドの比較
        Hour other = (Hour) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
