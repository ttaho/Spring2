package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculateGrade() {

                    //학점수x교과목평점의 합계          나누기       수강신청 총학점 수
        return courses.multiplyCreditAndCourseGrade() / courses.calculateTotalCompletedCredit();
    }
}
