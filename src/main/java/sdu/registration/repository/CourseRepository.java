package sdu.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sdu.registration.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
