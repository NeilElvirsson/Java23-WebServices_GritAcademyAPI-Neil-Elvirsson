package com.example.GritAcademyWebServicesAPI.Courses;

import com.example.GritAcademyWebServicesAPI.Students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getAllCourses() {
        List<CoursesDTO> courses = coursesService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> getCoursesById(
            @PathVariable(value = "id", required = true) Long id) {
        Optional<CoursesDTO> courses = coursesService.getCourseById(id);

        if(courses.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(courses.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/coursename/{course_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> getCoursesByCourseName(
            @PathVariable(value = "course_name", required = true)String courseName) {
        Optional<CoursesDTO> courses = coursesService.getCoursesByName(courseName);

        if(courses.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(courses.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/description/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoursesDTO> getCoursesByDescription(
            @PathVariable(value = "description", required = true)String description) {
        Optional<CoursesDTO> courses = coursesService.getCoursesDescription(description);

        if(courses.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(courses.get(), HttpStatus.OK);
    }

    //Search for just a word when searching for the course name
    @GetMapping(value = "/courses/contains/{searchTerm}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> coursesByCourseNameContains(
            @PathVariable(value = "searchTerm")String searchTerm) {
        List<CoursesDTO> courses = coursesService.getCoursesContainsName(searchTerm);

        if(courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    //Search for just a word in the description
    @GetMapping(value = "/courses/description-contains/{searchTerm}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> coursesByDescriptionContains(
            @PathVariable(value = "searchTerm")String searchTerm) {
        List<CoursesDTO> courses = coursesService.getCoursesContainsDescription(searchTerm);

        if(courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
