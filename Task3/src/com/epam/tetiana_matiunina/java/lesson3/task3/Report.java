package com.epam.tetiana_matiunina.java.lesson3.task3;


import java.util.Date;
import java.util.List;

import static com.epam.tetiana_matiunina.java.lesson3.task3.DateProcessor.*;


/**
 * Created by Tetiana_Matiunina on 22.10.2015.
 */
public class Report {
    private Student student;


    public Report(Student assignStudent) {
        student = assignStudent;
    }

    /**
     * @param courses List of courses in program
     * @return list of courses as a string
     */
    public String getCoursesAsString(List<Course> courses) {
        String resString = "";
        for (Course course : courses) {
            resString += course.toString();
        }
        return resString;
    }


    /**
     * determines all information about student's program
     *
     * @param typeOfReport full report 1 or small 0
     * @return return information report about student and his course
     */
    public String reporting(int typeOfReport, Date date) {
        if (typeOfReport == 0) {
            return shortReporting();
        } else {
            return fullReporting(date);
        }
    }

    private String shortReporting() {
        StringBuilder reportInfo = new StringBuilder();
        reportInfo.append("Name of student: " + student.getStudentName() + " " + student.getStudentSurname() + " ");
        reportInfo.append("(" + student.getProgram().getName() + ")" + "\n");
        if (isProgramSigned()) {
            reportInfo.append("Date of course start: " + formatDate(student.getProgram().getStartData()) + "\n");
            reportInfo.append(getCoursesAsString(student.getProgram().getCoursesList()));
        } else {
            reportInfo.append("No assigned courses for this student\n");
        }
        return reportInfo.toString();
    }


    private String fullReporting(Date date) {
        StringBuilder reportInfo = new StringBuilder();
        Date startDate = student.getProgram().getStartData();
        Date endDate = student.getProgram().getProgramEnd();

        reportInfo.append("Student: " + student.toString() + "\n");
        reportInfo.append("Specialization of the student: " + student.getProgram().getName() + " - " + student.getProgram().countTotalDuration() + " hours" + "\n");
        if (isProgramSigned()) {
            reportInfo.append("Start date of the course: " + formatDate(startDate) + "\n");
            reportInfo.append("End date of the course: " + formatDate(endDate) + "\n");
            if (date.after(endDate)) {
                reportInfo.append("Program has finished" + " - ");
                reportInfo.append(getDaysInterval(date, endDate) + " days " + getHoursInterval(date, endDate) + " hours ago" + "\n");
            } else if (date.before(startDate)) {
                reportInfo.append("Program doesn't start  \n");
            } else {
                reportInfo.append("Program in progress  \n");
                reportInfo.append("After start: " + getDaysInterval(date, startDate) + " day, " + getHoursInterval(date, startDate)
                        + " h - Before end: " + getDaysInterval(endDate, date) + " day " + getHoursInterval(endDate, date) + " h" + "\n");
            }
            reportInfo.append(getCoursesAsString(student.getProgram().getCoursesList()));
        } else {
            reportInfo.append("No assigned courses for this student\n");
        }
        return reportInfo.toString();
    }

    /**
     * check if student signed on the program
     *
     * @return true if student signed on the program, false if not
     */
    private boolean isProgramSigned() {
        return student.getProgram() != null;
    }


}

