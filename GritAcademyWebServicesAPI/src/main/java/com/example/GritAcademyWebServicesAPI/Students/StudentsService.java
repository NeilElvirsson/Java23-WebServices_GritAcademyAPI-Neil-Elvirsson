package com.example.GritAcademyWebServicesAPI.Students;

import com.example.GritAcademyWebServicesAPI.Courses.Courses;
import com.example.GritAcademyWebServicesAPI.Courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getAllStudents() {

        List<StudentsDTO> studentsDTO = new ArrayList<>();

       return studentsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<StudentsDTO> getStudentById(Long id) {

        return studentsRepository.findById(id).map(this::mapToDTO);

    }

    public Optional<StudentsDTO> getStudentByFName(String fName) {
        Optional<Students> studentsOptional = studentsRepository.findByfName(fName);
        return studentsOptional.map(this::mapToDTO);
    }

    public Optional<StudentsDTO> getStudentByLName(String lName) {
        Optional<Students> studentsOptional = studentsRepository.findBylName(lName);
        return studentsOptional.map(this::mapToDTO);
    }

    public Optional<StudentsDTO> getStudentByTown(String town) {
        Optional<Students> studentsOptional = studentsRepository.findByTown(town);
        return studentsOptional.map(this::mapToDTO);
    }

    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getCourseName());

        return dto;
    }

    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        dto.setCourses(students.getCourses().stream().map(this::mapToDTO).collect(Collectors.toList()));
        System.out.println(students.getCourses());

        return dto;
    }


}
