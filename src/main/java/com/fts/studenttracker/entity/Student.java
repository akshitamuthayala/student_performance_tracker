package com.fts.studenttracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "roll_number", unique = true)
    private String rollNumber;

    @Enumerated(EnumType.STRING)
    private Year year;

    private String section;

    private String grade;

    public enum Year {
        FIRST, SECOND
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public Year getYear() { return year; }
    public void setYear(Year year) { this.year = year; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
