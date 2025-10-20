package com.gotcha.part_time_management.domain.type;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 時刻を時分単位で表す
 */
public class HourTime {

    LocalTime value;

    HourTime(int hour, int minutes) {
        // ofメソッドは、「既存の値や素になるデータを受け取り、新たなオブジェクトを生成するファクト的メソッド」を意図する
        value = LocalTime.of(hour, minutes);
    }

    @Override
    public String toString(){
        return String.format("%d:%d", value.getHour(), value.getMinute());
    }
}
