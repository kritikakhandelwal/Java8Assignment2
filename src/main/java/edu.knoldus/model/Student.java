package edu.knoldus.model;

import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private Integer rollNumber;
    private Optional<List<String>> subjectList;


    public Student(String name, Integer rollNo, Optional<List<String>> subjectList) {
        this.name = name;
        this.rollNumber = rollNo;
        this.subjectList = subjectList;

    }

    public String getName() {
        return name;
    }



    public Optional<List<String>> getSubjectList() {
        return subjectList;
    }

    @Override
    public String toString() {
        return name + " " + rollNumber + " " + subjectList;
    }

}

