package com.gotcha.part_time_management.domain.type;

public class Amount {

    public final int MIN = 0;
    public final int MAX = 999999999;

    int value;

    public Amount(int value) {
        if (!validated(value)) {
            throw new IllegalArgumentException("金額が不正です。");
        }
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public Amount add(Amount other) {
        return new Amount(value + other.value);
    }

    public Amount multiply(int multiplier) {
        int result = Math.multiplyExact(value, multiplier);
        return new Amount(result);
    }

    public Amount divide(int divisor) {
        return new Amount(value / divisor);
    }

    private boolean validated(int value) {
        return (MIN <= value || value <= MAX);

    }
}
