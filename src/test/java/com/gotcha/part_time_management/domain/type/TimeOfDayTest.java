package com.gotcha.part_time_management.domain.type;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TimeOfDayTest {

    @Test
    void 文字列フォーマットがH時m分形式であること() {
        Hour hour = new Hour(1);
        Minute minute = new Minute(11);
        TimeOfDay time = new TimeOfDay(hour, minute);
        assertEquals("1時11分", time.toString());
    }
}
