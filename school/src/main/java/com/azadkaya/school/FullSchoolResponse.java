package com.azadkaya.school;

import java.util.ArrayList;
import java.util.List;

public class FullSchoolResponse {

    private String name;
    private String email;
    private List<Student> students = new ArrayList<>();

    public FullSchoolResponse() {
    }

    public FullSchoolResponse(String name, String email, List<Student> students) {
        this.name = name;
        this.email = email;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static class FullSchoolResponseBuilder {
        private String name;
        private String email;
        private List<Student> students = new ArrayList<>();

        public FullSchoolResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FullSchoolResponseBuilder email(String email) {
            this.email = email;
            return this;
        }
        public FullSchoolResponseBuilder students(List<Student> students) {
            this.students = students;
            return this;
        }
        public FullSchoolResponse build() {
            return new FullSchoolResponse(name, email, students);
        }
    }
}
