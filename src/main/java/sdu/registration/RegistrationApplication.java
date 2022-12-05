package sdu.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sdu.registration.repository.CourseRepository;

@SpringBootApplication
public class RegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }

    @Autowired
    private CourseRepository courseRepository;

//    @Override
//    public void run(String... args) throws Exception {
//        Course course = new Course("ICT", 5);
//        courseRepository.save(course);
//    }
}
