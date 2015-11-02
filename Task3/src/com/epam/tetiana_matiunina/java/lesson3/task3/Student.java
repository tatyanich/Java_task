package com.epam.tetiana_matiunina.java.lesson3.task3;

/**
 * Created by Tetiana_Matiunina on 22.10.2015.
 */
public class Student {
    private String studentName;
    private String studentSurname;
    private String studentPat;


    private Program program;

    public Student(String studentName, String studentSurname, String studentPat) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentPat = studentPat;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return getStudentSurname() + " " + getStudentName() + " " + this.studentPat;
    }

}
