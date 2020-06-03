package org.example.service;

import org.example.model.CalendarDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalendarServiceJavaTime implements CalendarService {

    @Override
    public CalendarDay[] getYear(int year) {
        LocalDate start = LocalDate.ofYearDay(year, 1);
        LocalDate end = LocalDate.ofYearDay(year + 1, 1);
        return generate(start, end);
    }

    @Override
    public CalendarDay[] getMonthInYear(Month month, int year) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = LocalDate.of(year, month.plus(1), 1);
        return generate(start, end);
    }

    private CalendarDay[] generate(LocalDate startInclusive, LocalDate endExclusive){
        long limit = DAYS.between(startInclusive, endExclusive);
        return Stream.iterate(startInclusive, date -> date.plusDays(1))
                .limit(limit)
                .map(CalendarDay::new)
                .toArray(CalendarDay[]::new);
    }

    @Override
    public CalendarDay[] getWeekInYear(int weekNumber, int year) {
        return Stream.of(getYear(year))
                .filter(day -> day.getYearWeek() == weekNumber)
                .toArray(CalendarDay[]::new);
    }

    @Override
    public CalendarDay[] getDaysBetween(LocalDate startInclusive, LocalDate endInclusive) {
        return generate(startInclusive, endInclusive.plusDays(1));
    }

    @Override
    public CalendarDay[] getMonthInYearWithFillers(Month month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = LocalDate.of(year, month.plus(1), 1).minusDays(1);

        LocalDate realFirstDay = firstDayOfMonth.getDayOfWeek() == DayOfWeek.MONDAY ? firstDayOfMonth : getLastMonday(firstDayOfMonth);
        LocalDate realLastDay = lastDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY ? lastDayOfMonth : getNextSunday(lastDayOfMonth);

        return getDaysBetween(realFirstDay, realLastDay);
    }

    private LocalDate getNextSunday(LocalDate date) {
        return date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }

    private LocalDate getLastMonday(LocalDate date){
        return date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
    }

    @Override
    public CalendarDay[] getWeekWithFillers(int weekNumber, int year) {
        return new CalendarDay[0];
    }
}
