package sdu.registration.entity;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseID;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "credits")
    private int credits;

    public Course() {

    }

    public Course(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
