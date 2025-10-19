package com.gotcha.part_time_management.domain.type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HourlyWageTest {

    @Test
    void 時給の値オブジェクトが生成されることを確認() throws Exception {
        Amount amount = new Amount(100);
        HourlyWage hourlyWage = new HourlyWage(amount);
        assertTrue(true);
    }
}