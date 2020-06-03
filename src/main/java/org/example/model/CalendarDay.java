package org.example.model;

import org.threeten.extra.YearWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class CalendarDay {

    private final LocalDate date;
    private final int year;
    private final Month month;
    private final int yearWeek;
    private final DayOfWeek weekDay;
    private final int dayOfMonth;

    public CalendarDay(LocalDate date) {
        this.date = date;
        this.year = date.getYear();
        this.month = date.getMonth();
        this.weekDay = date.getDayOfWeek();
        this.dayOfMonth = date.getDayOfMonth();
        this.yearWeek = YearWeek.from(date).getWeek();
    }

    public LocalDate getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getYearWeek() {
        return yearWeek;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarDay that = (CalendarDay) o;
        return Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate());
    }

    @Override
    public String toString() {
        return "CalendarDay{" +
                "date=" + date +
                '}';
    }
}
