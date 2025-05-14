package com.azadkaya.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    public List<Student> findAllStudentsBySchoold(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
