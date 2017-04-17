package bg.softuni.repository;

import bg.softuni.dataStructures.SimpleOrderedBag;
import bg.softuni.models.Course;
import bg.softuni.models.Student;

import java.util.Comparator;

/**
 * Created by vladix on 4/17/17.
 */
public interface Request {
    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleOrderedBag<Course>  getAllCoursedSorted(Comparator<Course> cmp);

    SimpleOrderedBag<Student>  getAllStudentsSorted(Comparator<Student> cmp);

}
