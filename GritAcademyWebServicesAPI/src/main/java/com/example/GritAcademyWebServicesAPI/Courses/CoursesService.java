package com.example.GritAcademyWebServicesAPI.Courses;

import com.example.GritAcademyWebServicesAPI.Students.Students;
import com.example.GritAcademyWebServicesAPI.Students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public List<CoursesDTO> getAllCourses() {
        List<CoursesDTO> coursesDTO = new ArrayList<>();
        return coursesRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public Optional<CoursesDTO> getCourseById(Long id) {

        return coursesRepository.findById(id).map(this::mapToDTO);

    }

    public Optional<CoursesDTO> getCoursesByName(String courseName) {
        Optional<Courses> coursesOptional = coursesRepository.findByCourseName(courseName);
        return coursesRepository.findByCourseName(courseName).map(this::mapToDTO);
    }


    public List<CoursesDTO> getCoursesContainsName(String searchTerm) {
           List<Courses> courses = coursesRepository.findByCourseNameContaining(searchTerm);
            return courses.stream().map(this::mapToDTO).collect(Collectors.toList());

    }

    public Optional<CoursesDTO> getCoursesDescription(String description) {
        Optional<Courses> coursesOptional = coursesRepository.findByDescription(description);
        return coursesRepository.findByDescription(description).map(this::mapToDTO);

    }

    public List<CoursesDTO> getCoursesContainsDescription(String searchTerm) {
        List<Courses> courses = coursesRepository.findByDescriptionContaining(searchTerm);
        return courses.stream().map(this::mapToDTO).collect(Collectors.toList());


    }



    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getCourseName());
        dto.setDescription(courses.getDescription());

        dto.setStudents(courses.getStudents().stream().map(this::mapToDTO).collect(Collectors.toList()));

        System.out.println("course description !!! HEY YOO!!  :" + courses.getDescription());
        System.out.println("courses dto" + courses.getStudents());
        return dto;
    }


    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());

       // dto.setCourses(students.getCourses().stream().map(this::mapToDTO).collect(Collectors.toList()));
        System.out.println("students dto" + students.getCourses());

        return dto;
    }
/*
    public List<CoursesDTO> getCoursesBySearchTerm(String searchTerm) {
        List<CoursesDTO> coursesDTO = new ArrayList<>();
        List<Courses> courses = coursesRepository.findByCourseNameContainingIgnoreCase(searchTerm);
        return  courses.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


 */
}
