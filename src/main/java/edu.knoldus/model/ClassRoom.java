package edu.knoldus.model;

import java.util.List;
import java.util.Optional;

public class ClassRoom {
    private String roomId;
    private Optional<List<Student>> studentList;

    public ClassRoom(String roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;

    }

    public String getRoomId() {
        return roomId;
    }

    public Optional<List<Student>> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return roomId + " " + studentList + " ";
    }


}
