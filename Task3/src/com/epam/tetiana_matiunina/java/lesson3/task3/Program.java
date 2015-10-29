package com.epam.tetiana_matiunina.java.lesson3.task3;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Администратор on 22.10.2015.
 */
public class Program {
    private Date programStart;
    private Calendar calendar = Calendar.getInstance();

    public String getName() {
        return name;
    }

    private String name;
    private List<Course> courses = new ArrayList<Course>();
    private Date programEnd;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Date getProgramEnd() {
        return programEnd;
    }

    public Date getStartData() {
        return this.programStart;
    }

    /**
     * add list off some courses to the program
     *
     * @param courses List of courses
     * @return list courses of program
     */
    public List<Course> addCourses(List<Course> courses) {
        for (Course course : courses) {
            this.courses.add(course);
        }
        return this.courses;
    }


    public List<Course> getCoursesList() {
        return this.courses;
    }

    public Program(String name, String date) {
        this.name = name;
        try {
            simpleDateFormat.setLenient(false);
            this.programStart = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    /**
     * count general duration of Program
     *
     * @return total duration of Program
     */
    public int countTotalDuration() {
        int totalHours = 0;
        for (Course course : this.courses) {
            totalHours += course.getDuration();

        }
        return totalHours;
    }

    /**
     * calculate end date of the program using total duration of program
     *
     * @throws NullPointerException
     */
    public void calculateEndDate() throws NullPointerException{
        int hourPerWorkingDay = 8;
        try {
            calendar.setTime(programStart);
            calendar.add(Calendar.DAY_OF_MONTH, countTotalDuration() / hourPerWorkingDay);
            calendar.add(Calendar.HOUR_OF_DAY, countTotalDuration() % hourPerWorkingDay);
            programEnd = calendar.getTime();
        } catch (NullPointerException e) {
            Logger.getLogger(Program.class.toString()).info("Unable to parse date value'" + programStart + "'. Error message: " + e.getMessage());

        }
    }

}
