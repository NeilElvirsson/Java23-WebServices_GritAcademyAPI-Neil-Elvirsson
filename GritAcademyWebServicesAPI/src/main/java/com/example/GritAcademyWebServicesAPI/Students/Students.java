package com.example.GritAcademyWebServicesAPI.Students;

import com.example.GritAcademyWebServicesAPI.Courses.Courses;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
@Table(name = "students")
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Students {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "fName")
    private String fName;

    @Column(name = "lName")
    private String lName;

    @Column(name = "town")
    private String town;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name="students_id"),
            inverseJoinColumns =  @JoinColumn(name="courses_id"))
    private Set<Courses> courses = new HashSet<>();


}
