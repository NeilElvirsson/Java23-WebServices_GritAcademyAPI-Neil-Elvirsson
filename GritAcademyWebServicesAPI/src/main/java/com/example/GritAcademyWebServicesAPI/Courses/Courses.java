package com.example.GritAcademyWebServicesAPI.Courses;

import com.example.GritAcademyWebServicesAPI.Students.Students;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "courses")
@Table(name = "courses")
//@Data

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Courses {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "students_id"),
    inverseJoinColumns = @JoinColumn(name = "courses_id"))

    private Set<Students> students = new HashSet<>();
}
