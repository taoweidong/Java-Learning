package com.java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * Java8日期格式学习<br>
 * jdk1.8的示例
 * @author taowd
 * @version 2019年4月27日
 * @see Java8Date
 */
public class Java8Date {

	public static void main(String[] args) {

		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());

		// 判断是否是闰年
		System.out.println(LocalDate.now().isLeapYear());

		// 比较两个 LocalDate
		System.out.println(LocalDate.now().getDayOfMonth());

		// 时间戳
		Instant begin = Instant.now();
		Instant end = Instant.ofEpochMilli(2000000);

		Duration dd = Duration.between(end, begin);
		System.out.println(dd.toMillis());

		System.out.println("---------------");

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.of(2019, 2, 26);
		Period period = Period.between(endDate, startDate);
		System.out.println(period.getMonths());

		System.out.println("---------------");
		// 时间矫正器
		System.out
				.println("本月第一天：" + LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(
				"下月第一天：" + LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println(
				"下年第一天：" + LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.println("本月第一个SUNDAY："
				+ LocalDateTime.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));
		System.out
				.println("本月最后一天：" + LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println("本年最后一天：" + LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear()));
		System.out.println("本年最后一天："
				+ LocalDate.of(2019, 4, 12).with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
	}

}
