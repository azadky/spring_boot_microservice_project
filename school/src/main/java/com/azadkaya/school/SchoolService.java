package com.azadkaya.school;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    public SchoolService(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

    public void save(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        new School.SchoolBuilder()
                                .name("NOT FOUND")
                                .email("NOT FOUND")
                                .build()
                );
        List<Student> students = studentClient.getStudents(schoolId);


        return new FullSchoolResponse.FullSchoolResponseBuilder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
