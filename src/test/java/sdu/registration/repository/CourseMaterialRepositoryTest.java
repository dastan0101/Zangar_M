package sdu.registration.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sdu.registration.entity.Course;
import sdu.registration.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = new Course();
        course.setCourseName("Java");
        course.setCredits(5);

        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.setCourseMaterial("www.java.com");
        courseMaterial.setCourse(course);

        courseMaterialRepository.save(courseMaterial);
    }
}