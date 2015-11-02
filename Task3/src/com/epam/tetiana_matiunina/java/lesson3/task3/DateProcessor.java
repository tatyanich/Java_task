package com.epam.tetiana_matiunina.java.lesson3.task3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class DateProcessor {
    private static final int convertToHours = 1000 * 60 * 60;
    public static final int hourPerDay = 24;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    /**
     * @param date
     * @return format date as string
     */
    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }

    /**
     * counts difference between current date and date of end
     *
     * @param date date of program's end
     * @return difference between dates in hours
     */
    private static int getDifferenceInDate(Date todayDate, Date date) {
        long differenceTime = (todayDate.getTime() - date.getTime()) / convertToHours;
        return (int) differenceTime;
    }

    /**
     * @param firstDate
     * @param secondDate
     * @return amount of days between firstDate and secondDate
     */
    public static int getDaysInterval(Date firstDate, Date secondDate) {
        return Math.abs(getDifferenceInDate(firstDate, secondDate) / hourPerDay);
    }

    /**
     * @param firstDate
     * @param secondDate
     * @return amount of hours between firstDate and secondDate
     */
    public static int getHoursInterval(Date firstDate, Date secondDate) {
        return Math.abs(getDifferenceInDate(firstDate, secondDate) % hourPerDay);
    }


}
