package org.example.service;

import org.example.model.CalendarDay;

import java.time.LocalDate;
import java.time.Month;

public interface CalendarService {
    CalendarDay[] getYear(int year);
    CalendarDay[] getMonthInYear(Month month, int year);
    CalendarDay[] getWeekInYear(int weekNumber, int year);
    CalendarDay[] getDaysBetween(LocalDate startInclusive, LocalDate endInclusive);
    CalendarDay[] getMonthInYearWithFillers(Month month, int year);
    CalendarDay[] getWeekWithFillers(int weekNumber, int year);
}
