package edu.knoldus.view;

import java.util.List;


import edu.knoldus.model.Student;
import edu.knoldus.model.ClassRoom;

import static java.util.stream.Collectors.toList;

public class StudentApp {


    public static List<Student> studentwithnosub(List<ClassRoom> classRoomlist) {
        //get classrooms having student list.
        List<ClassRoom> classRoom = classRoomlist.stream().filter(c -> c.getStudentList().isPresent())
                .collect(toList());

        //extract list of students from selected classrooms
        List<List<Student>> studentslist = classRoom.stream().map(c -> c.getStudentList().get())
                .collect(toList());

        //filter students with no subjects
        List<Student> slist = studentslist.stream().flatMap(x -> x.stream())
                .filter(s -> !s.getSubjectList().isPresent()).collect(toList());

        return slist;
    }

    public static List<String> studentsSub(String id, List<ClassRoom> classRoomList) {
        List<ClassRoom> classRoom = classRoomList.stream().filter(ClassRoom -> ClassRoom.getStudentList()
                .isPresent() && ClassRoom.getRoomId().equals(id)).collect(toList());
        List<List<Student>> studentslist = classRoom.stream()
                .map(c -> c.getStudentList().get()).collect(toList());
        List<Student> slist = studentslist.stream().flatMap(x -> x.stream())
                .filter(s -> s.getSubjectList().isPresent()).collect(toList());
        List<List<String>> subjectList = slist.stream().map(s -> s.getSubjectList().get()).collect(toList());
        List<String> subList = subjectList.stream().flatMap(s -> s.stream()).collect(toList());
        return subList;
    }

    public static List<String> sayHello(List<ClassRoom> classRoomList) {
        List<ClassRoom> classRooms = classRoomList
                .stream().filter(ClassRoom -> ClassRoom.getStudentList().isPresent())
                .collect(toList());
        List<List<Student>> studentList = classRooms.stream().map(x -> x.getStudentList().get())
                .collect(toList());
        List<Student> slist = studentList.stream().flatMap(s -> s.stream()).collect(toList());
        List<String> names = slist.stream().map(s -> s.getName()).collect(toList());
        return names;
    }


}
