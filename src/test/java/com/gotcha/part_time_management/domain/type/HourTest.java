package com.gotcha.part_time_management.domain.type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HourTest {

    @Test
    void 整数から時間オブジェクトが生成されること() {
        Hour hour = new Hour(1);
        assertEquals("1", hour.toString());
    }

    @Test
    void 値オブジェクト同士の比較が同値によって比較されること() {
        Hour hour = new Hour(1);
        Hour other = new Hour(1);
        assertTrue(hour.equals(other));
    }
}
