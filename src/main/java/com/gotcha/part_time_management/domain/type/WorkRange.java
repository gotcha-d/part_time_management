package com.gotcha.part_time_management.domain.type;

/**
 * 労働時間
 */
public class WorkRange {
    TimeOfDay from;
    TimeOfDay to;

    WorkRange(TimeOfDay from, TimeOfDay to) {
        this.from = from;
        this.to = to;
    }

    /**
     * 分表記に変換
     */
    public WorkMinutes toWorkTime() {

      int fromMin = from.toMinuteOfDay().intValue();
      int toMin = to.toMinuteOfDay().intValue();

      if (isNextDay(fromMin, toMin)) {
        return WorkMinutes.ofMinutes(toMin + MinutesOfDay.MAX - fromMin);
      }

      return WorkMinutes.ofMinutes(toMin - fromMin);
    }

    private boolean isNextDay(int fromMin, int toMin) {
        return toMin < fromMin;
    }
}
