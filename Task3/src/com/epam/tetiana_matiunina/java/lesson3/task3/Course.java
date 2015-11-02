package com.epam.tetiana_matiunina.java.lesson3.task3;

/**
 * Created by Tetiana_Matiunina on 22.10.2015.
 */
public class Course {
    private String name;
    private int duration;

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course: " + getName() + ", Duration: " + getDuration() + "\n";
    }

}
