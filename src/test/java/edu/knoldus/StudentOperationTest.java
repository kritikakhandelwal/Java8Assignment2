package edu.knoldus;

import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;
import edu.knoldus.view.StudentApp;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * student class test cases.
 */
public class StudentOperationTest {

    private List<String> sub = Arrays.asList("eng", "math");
    private Student student1 = new Student("Kritika", Constant.Seventeen, Optional.of(sub));
    private Student student2 = new Student("Bhawna", Constant.Eighteen, Optional.empty());
    private Student student3 = new Student("Neelam", Constant.Nineteen, Optional.of(sub));

    private List<Student> studentsList = Arrays.asList(student1, student2, student3);
    private ClassRoom class1 = new ClassRoom("xyz", Optional.of(studentsList));
    private ClassRoom class2 = new ClassRoom("abc", Optional.empty());
    private List<ClassRoom> classRoomL = Arrays.asList(class1, class2);


    @Test
    public final void addTest() {

        List<Student> studentListTest = StudentApp.studentwithnosub(classRoomL);
        List<String> expectedSubject = Arrays.asList("eng", "math", "eng", "math");
        List<String> getSubject = StudentApp.studentsSub("xyz", classRoomL);
        List<String> getSayHello = StudentApp.sayHello(classRoomL);
        List<String> expextedStudentList = Arrays.asList("Kritika", "Bhawna", "Neelam");
        assertEquals(studentListTest, Arrays.asList(student2));
        assertEquals(expectedSubject, getSubject);
        assertEquals(expextedStudentList, getSayHello);

    }
}
