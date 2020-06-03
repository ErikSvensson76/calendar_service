package org.example.service;

import org.example.model.CalendarDay;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class CalendarServiceJavaTimeTest {

    CalendarService testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new CalendarServiceJavaTime();
    }

    @Test
    public void given_year_getYear_should_return_whole_year() {
        int year = 2020;

        LocalDate expectedFirst = LocalDate.parse("2020-01-01");
        LocalDate expectedLast = LocalDate.parse("2020-12-31");
        int expectedLength = 366;

        CalendarDay[] result = testObject.getYear(year);

        assertEquals(expectedLength, result.length);
        assertEquals(expectedFirst, result[0].getDate());
        assertEquals(expectedLast, result[result.length-1].getDate());
    }

    @Test
    public void given_month_getMonthInYear_return_whole_month() {
        Month month = Month.FEBRUARY;
        int year = 2020;

        int expectedLength = 29;
        LocalDate firstDay = LocalDate.parse("2020-02-01");
        LocalDate lastDay = LocalDate.parse("2020-02-29");

        CalendarDay[] result = testObject.getMonthInYear(month, year);

        assertEquals(expectedLength, result.length);
        assertEquals(firstDay, result[0].getDate());
        assertEquals(lastDay, result[result.length-1].getDate());
    }

    @Test
    public void given_week53_and_year_2020_getWeekInYear_return_correct_data(){
        int week53 = 53;
        int year = 2020;

        int expectedLength = 4;
        LocalDate firstDay = LocalDate.parse("2020-12-28");
        LocalDate lastDay = LocalDate.parse("2020-12-31");

        CalendarDay[] result = testObject.getWeekInYear(week53, year);

        assertEquals(expectedLength, result.length);
        assertEquals(firstDay, result[0].getDate());
        assertEquals(lastDay, result[result.length-1].getDate());
    }

    @Test
    public void given_week1_and_year_2021_getWeekInYear_return_correct_data(){
        int week1 = 1;
        int year = 2021;

        int expectedLength = 7;
        LocalDate firstDay = LocalDate.parse("2021-01-04");
        LocalDate lastDay = LocalDate.parse("2021-01-10");

        CalendarDay[] result = testObject.getWeekInYear(week1, year);

        assertEquals(expectedLength, result.length);
        assertEquals(firstDay, result[0].getDate());
        assertEquals(lastDay, result[result.length-1].getDate());
    }

    @Test
    public void given_start_and_end_getDates_between_should_return_correct_data() {
        LocalDate start = LocalDate.parse("2020-06-03");
        LocalDate end = LocalDate.parse("2020-06-07");

        int expectedLength = 5;

        CalendarDay[] result = testObject.getDaysBetween(start, end);

        assertEquals(expectedLength, result.length);
        assertEquals(start, result[0].getDate());
        assertEquals(end, result[result.length-1].getDate());
    }

    @Test
    public void given_month_and_year_getEvenMonthInYear_should_return_correct_data_may() {
        Month month = Month.MAY;
        int year = 2020;

        LocalDate firstDay = LocalDate.parse("2020-04-27");
        LocalDate lastDay = LocalDate.parse("2020-05-31");
        int expectedLength = 35;

        CalendarDay[] result = testObject.getMonthInYearWithFillers(month, year);

        assertEquals(expectedLength, result.length);
        assertEquals(firstDay, result[0].getDate());
        assertEquals(lastDay, result[result.length-1].getDate());
    }

    @Test
    public void given_month_and_year_getEvenMonthInYear_should_return_correct_data_june() {
        Month month = Month.JUNE;
        int year = 2020;

        LocalDate firstDay = LocalDate.parse("2020-06-01");
        LocalDate lastDay = LocalDate.parse("2020-07-05");
        int expectedLength = 35;

        CalendarDay[] result = testObject.getMonthInYearWithFillers(month, year);

        assertEquals(expectedLength, result.length);
        assertEquals(firstDay, result[0].getDate());
        assertEquals(lastDay, result[result.length-1].getDate());
    }
}
