package com.azadkaya.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        schoolService.save(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }


    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findSchoolsWithStudents(@PathVariable Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolWithStudents(schoolId));

    }
}
