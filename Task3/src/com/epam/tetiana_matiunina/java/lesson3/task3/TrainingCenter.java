package com.epam.tetiana_matiunina.java.lesson3.task3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Matiunina on 22.10.2015.
 */
public class TrainingCenter {

    public static void main(String[] args) {
        Student stud1 = new Student("Tanya", "Matiunina", "Vladimirovna");
        Course course1 = new Course("Begin java", 24);
        Course course2 = new Course("Hello World", 24);
        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);

        Program program1 = new Program("Java program", "28/14/2015 10:00");
        program1.addCourses(courses);

        program1.calculateEndDate();
        stud1.setProgram(program1);
        Report report = new Report(stud1);
        System.out.println(report.reporting());

    }
}
