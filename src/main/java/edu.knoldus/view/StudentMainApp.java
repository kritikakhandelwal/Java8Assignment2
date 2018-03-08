package edu.knoldus.view;

import edu.knoldus.Constant;
import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class StudentMainApp {
    public static void main(String[] args) {
        List<String> subjects = Arrays.asList("eng", "math");
        Student student1 = new Student("Kritika", Constant.Seventeen, Optional.of(subjects));
        Student student2 = new Student("Bhawna", Constant.Eighteen, Optional.empty());
        Student student3 = new Student("Neelam", Constant.Nineteen, Optional.of(subjects));

        List<Student> studentsList = Arrays.asList(student1, student2, student3);
        ClassRoom class1 = new ClassRoom("xyz", Optional.of(studentsList));
        ClassRoom class2 = new ClassRoom("abc", Optional.empty());
        List<ClassRoom> classRoomL = Arrays.asList(class1, class2);


        System.out.println("Student with no subject:");
        List<Student> studentwithNoSub = StudentApp.studentwithnosub(classRoomL);
        System.out.print(studentwithNoSub);


        List<String> studentsSub = StudentApp.studentsSub("xyz", classRoomL);
        System.out.println(studentsSub);

        List<String> sayHelloStudents = StudentApp.sayHello(classRoomL);
        System.out.println("Hello" + sayHelloStudents);
        System.out.println("Subjects");

    }

}
