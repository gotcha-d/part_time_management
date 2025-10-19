package com.gotcha.part_time_management.domain.type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MinuteTest {

    @Test
    void 整数から時間オブジェクトが生成されること() {
        Minute minute = new Minute(1);
        assertEquals("1", minute.toString());
    }

    @Test
    void 値オブジェクト同士の比較が同値によって比較されること() {
        Minute minute = new Minute(1);
        Minute other = new Minute(1);
        assertTrue(minute.equals(other));
    }
}
