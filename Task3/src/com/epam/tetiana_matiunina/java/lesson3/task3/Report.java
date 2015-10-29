package com.epam.tetiana_matiunina.java.lesson3.task3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 22.10.2015.
 */
public class Report {
    private Student student;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private int hourPerDay = 24;

    public Report(Student assignStudent) {
        student = assignStudent;
    }

    /**
     * call method reporting with 0 parameter
     *
     * @return return a small report about student
     */
    public String reporting() {
        return reporting(0);
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
    public String reporting(int typeOfReport) {
        StringBuilder reportInfo = new StringBuilder();

        if (typeOfReport == 0) {
            reportInfo.append("Name of student: " + student.getStudentName() + " " + student.getStudentSurname() + " ");
            reportInfo.append("(" + student.getProgram().getName() + ")" + "\n");
            if ((student.getProgram().getStartData() != null) && (student.getProgram().getCoursesList() != null)) {
                reportInfo.append("Date of course start: " + simpleDateFormat.format(student.getProgram().getStartData()) + "\n");
                reportInfo.append(getCoursesAsString(student.getProgram().getCoursesList()));
            } else {
                reportInfo.append("No assigned courses for this student\n");
            }
            return reportInfo.toString();
        } else {
            reportInfo.append("Name of the student: " + student.toString() + "\n");
            reportInfo.append("Specialization of the student: " + student.getProgram().getName() + " - " + student.getProgram().countTotalDuration() + " hours" + "\n");
            if ((student.getProgram().getStartData() != null) && (student.getProgram().getCoursesList() != null)) {
                reportInfo.append("Start date of the course: " + simpleDateFormat.format(student.getProgram().getStartData()) + "\n");
                reportInfo.append("End date of the course: " + simpleDateFormat.format(student.getProgram().getProgramEnd()) + "\n");
                knowStateOfProgram(reportInfo);
                reportInfo.append(getCoursesAsString(student.getProgram().getCoursesList()));
            }
            return reportInfo.toString();
        }
    }

    /**
     * determines a state of current program and save to  the report information about amount of days and hours between current date and dates of program
     *
     * @param reportInfo all report information
     */
    private void knowStateOfProgram(StringBuilder reportInfo) {
        Date todayDate = new Date();
        if (todayDate.after(student.getProgram().getProgramEnd())) {
            reportInfo.append("Program has finished" + " - ");
            reportInfo.append(Math.abs(DateProcessor.getDifferenceInDate(student.getProgram().getProgramEnd()) / hourPerDay) + " days " +
                    Math.abs(DateProcessor.getDifferenceInDate(student.getProgram().getProgramEnd()) % hourPerDay) + " hours ago" + "\n");
        } else if (todayDate.before(student.getProgram().getStartData())) {
            reportInfo.append("Program doesn't start  \n");
        } else {
            reportInfo.append("Program in progress  \n");
            reportInfo.append(DateProcessor.knowRangeBetweenStartAndEnd(student.getProgram().getStartData(), student.getProgram().getProgramEnd()));
        }
    }


}

