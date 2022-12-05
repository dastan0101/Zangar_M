package sdu.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sdu.registration.entity.Course;
import sdu.registration.entity.CourseMaterial;
import sdu.registration.service.CourseService;

@Controller
public class CourseController {

    private CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "main";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "create_course";
    }

    @PostMapping("/main")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit_course";
    }

    @PostMapping("/courses/{id}")
    public String editCourse(@PathVariable Long id, @ModelAttribute("course") Course course, Model model) {
        Course oldCourse = courseService.getCourseById(id);
        oldCourse.setCourseID(id);
        oldCourse.setCourseName(course.getCourseName());
        oldCourse.setCredits(course.getCredits());

        courseService.editCourse(oldCourse);
        return "redirect:/courses";
    }

    @GetMapping("/courses/delete/{id}")
    public String removeCourse(@PathVariable Long id) {
        courseService.removeCourseById(id);
        return "redirect:/courses";
    }

    @PostMapping("/courses/add/material/{id}")
    public String addCourseMaterial(@PathVariable Long id,
                                    @ModelAttribute("course") Course course,
                                    Model model) {
        CourseMaterial material = new CourseMaterial();
        model.addAttribute("course_material", material);
        material.setCourse(course);

        courseService.addCourseMaterial(course, material);

        return "add_course_material";
    }
}
