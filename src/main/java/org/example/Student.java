package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private List<String> enrolledCourses;
    private HashMap<String,String> courseGrades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<String, String>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void enrollCourse(String course) {
        enrolledCourses.add(course);
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setGrade(String course, String grade) {
        courseGrades.put(course , grade);
    }

    public String getGrade(String course) {
        for (String coursename: courseGrades.keySet()) {
            if(Objects.equals(coursename, course)) {
                return courseGrades.get(coursename);
            }
        }
        return null;
    }

}
