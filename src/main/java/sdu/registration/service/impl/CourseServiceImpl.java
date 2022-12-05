package sdu.registration.service.impl;

import org.springframework.stereotype.Service;
import sdu.registration.entity.Course;
import sdu.registration.entity.CourseMaterial;
import sdu.registration.repository.CourseMaterialRepository;
import sdu.registration.repository.CourseRepository;
import sdu.registration.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private CourseMaterialRepository courseMaterialRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course editCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void removeCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course addCourseMaterial(Course course, CourseMaterial material) {
        material.setCourse(course);
        return courseRepository.save(course);
    }

    @Override
    public CourseMaterial getCourseMaterialByCourse(Course course) {
        int size = courseMaterialRepository.findAll().size();
        CourseMaterial material = null;
        for (int i = 0; i < size; i++) {
            if (courseMaterialRepository.findById((long)i).get().getCourse().equals(course)) {
                material =  courseMaterialRepository.findById((long)i).get();
                break;
            }
        }
        return material;

    }


}
