package org.example.service;

import org.example.model.CalendarDay;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalendarServiceJavaTime implements CalendarService {

    @Override
    public CalendarDay[] getYear(int year) {
        LocalDate start = LocalDate.ofYearDay(year, 1);
        LocalDate end = LocalDate.ofYearDay(year + 1, 1);
        long limit = DAYS.between(start, end);

        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(limit)
                .map(CalendarDay::new)
                .toArray(CalendarDay[]::new);
    }

    @Override
    public CalendarDay[] getMonthInYear(Month month, int year) {
        return new CalendarDay[0];
    }

    @Override
    public CalendarDay[] getWeekInYear(int weekNumber, int year) {
        return new CalendarDay[0];
    }

    @Override
    public CalendarDay[] getDaysBetween(LocalDate startInclusive, LocalDate endInclusive) {
        return new CalendarDay[0];
    }

    @Override
    public CalendarDay[] getMonthInYearWithFillers(Month month, int year) {
        return new CalendarDay[0];
    }

    @Override
    public CalendarDay[] getWeekWithFillers(int weekNumber, int year) {
        return new CalendarDay[0];
    }
}
