package com.example.GritAcademyWebServicesAPI.Students;

import com.example.GritAcademyWebServicesAPI.Courses.CoursesDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {

    private Long id;
    private String fName;
    private String lName;
    private String town;

    private List<CoursesDTO> courses;
}
