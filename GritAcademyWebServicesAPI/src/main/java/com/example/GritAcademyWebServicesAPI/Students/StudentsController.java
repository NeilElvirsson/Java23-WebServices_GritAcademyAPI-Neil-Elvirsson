package com.example.GritAcademyWebServicesAPI.Students;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentsController {

    @Autowired
    StudentsService studentService;

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getAllStudents() {
        List<StudentsDTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping(value = "/students/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> getStudentsById(
            @PathVariable(value = "id", required = true) Long id) {
        Optional<StudentsDTO> students = studentService.getStudentById(id);

        if(students.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/fName/{fName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> getStudentsByFName (
            @PathVariable(value = "fName", required = true)String fName) {
        Optional<StudentsDTO> students = studentService.getStudentByFName(fName);

        if(students.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/lName/{lName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> getStudentsByLName (
            @PathVariable(value = "lName", required = true)String lName) {
        Optional<StudentsDTO> students = studentService.getStudentByLName(lName);

        if(students.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/students/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsDTO> getStudentsTown (
            @PathVariable(value = "town", required = true)String town) {
        Optional<StudentsDTO> students = studentService.getStudentByTown(town);

        if(students.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(students.get(), HttpStatus.OK);
    }

}
