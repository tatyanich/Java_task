package com.epam.tetiana_matiunina.java.lesson3.task3;

import java.util.Date;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class DateProcessor {
    private static int convertToHours = 1000 * 60 * 60;
    private static int hourPerDay = 24;

    /**
     * counts difference between current date and date of end
     *
     * @param endDate date of program's end
     * @return difference between dates in hours
     */
    public static int getDifferenceInDate(Date endDate) {
        Date todayDate = new Date();
        long differenceTime = (todayDate.getTime() - endDate.getTime()) / convertToHours;
        return (int) differenceTime;
    }

    /**
     * counts how many days and hours have passed since start date and how many days and hours before end date
     *
     * @param startDate date of program's start
     * @param endDate   date of program's end
     * @return string with amount of days and hours since start date and before end date
     */
    public static String knowRangeBetweenStartAndEnd(Date startDate, Date endDate) {
        Date todayDate = new Date();
        long afterStart = (todayDate.getTime() - startDate.getTime()) / convertToHours;
        long beforeEnd = (endDate.getTime() - todayDate.getTime()) / convertToHours;
        return "After start: " + afterStart / hourPerDay + " day, " + afterStart % hourPerDay + " h - Before end: " + beforeEnd / hourPerDay + " day " + beforeEnd % hourPerDay + " h" + "\n";

    }
}
