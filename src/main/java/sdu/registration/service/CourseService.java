package sdu.registration.service;

import sdu.registration.entity.Course;
import sdu.registration.entity.CourseMaterial;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course editCourse(Course course);

    void removeCourseById(Long id);

    Course addCourseMaterial(Course course, CourseMaterial material);

    CourseMaterial getCourseMaterialByCourse(Course course);
}
