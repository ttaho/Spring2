package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }
    // 학점수*학점등급
    public double multiplyCreditAndCourseGrade() {
        //아래꺼랑 똑같음
        return courses.stream()
                .mapToDouble(Course::multiplyCreditCourseGrade)
                .sum();
//        double multipliedCreditAndCourseGrade = 0;
//
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multiplyCreditCourseGrade();
//        }
//        return multipliedCreditAndCourseGrade;
    }
    // 총 학점수
    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
