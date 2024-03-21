package com.example.GritAcademyWebServicesAPI.Courses;

import com.example.GritAcademyWebServicesAPI.Students.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {

    private Long id;
    private String name;
    private String description;

    private List<StudentsDTO> students;
}
