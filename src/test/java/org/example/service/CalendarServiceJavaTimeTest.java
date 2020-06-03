package org.example.service;

import org.example.model.CalendarDay;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

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
}
