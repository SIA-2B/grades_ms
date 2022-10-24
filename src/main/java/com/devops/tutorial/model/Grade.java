package com.devops.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "grade")
@EntityListeners(AuditingEntityListener.class)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradeId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "grade_final", nullable = false)
    private Double gradeFinal;

    @Column(name = "grade_period", nullable = false)
    private String gradePeriod;

 
    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getGradeFinal() {
        return gradeFinal;
    }

    public void setGradeFinal(Double gradeFinal) {
        this.gradeFinal = gradeFinal;
    }

    public String getGradePeriod() {
        return gradePeriod;
    }

    public void setGradePeriod(String gradePeriod) {
        this.gradePeriod = gradePeriod;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + gradeId +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", gradeFinal='" + gradeFinal + '\'' +
                ", gradePeriod='" + gradePeriod + '\'' +
                '}';
    }


}
