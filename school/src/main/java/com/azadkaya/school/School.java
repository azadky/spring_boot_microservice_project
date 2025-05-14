package com.azadkaya.school;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    public School() {
    }

    public School(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



    public static class SchoolBuilder{
        private Integer id;

        private String name;
        private String email;

        public SchoolBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public SchoolBuilder name(String name) {
            this.name = name;
            return this;
        }
        public SchoolBuilder email(String email) {
            this.email = email;
            return this;
        }
        public School build() {
            return new School(id, name, email);
        }

    }
}
