package org.example.model;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;


public class CalendarDayTest {
    public static final LocalDate DATE = LocalDate.parse("2020-06-03");
    private CalendarDay testObject;

    @Before
    public void setUp(){
        testObject = new CalendarDay(DATE);
    }

    @Test
    public void testObject_contains_correct_data() {
        assertNotNull(testObject);
        assertEquals(DATE, testObject.getDate());
        assertEquals(Month.JUNE, testObject.getMonth());
        assertEquals(23, testObject.getYearWeek());
        assertEquals(DayOfWeek.WEDNESDAY, testObject.getWeekDay());
        assertEquals(2020, testObject.getYear());
        assertEquals(3, testObject.getDayOfMonth());
    }


}
