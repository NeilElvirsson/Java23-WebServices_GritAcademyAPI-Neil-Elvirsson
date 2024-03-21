package com.example.GritAcademyWebServicesAPI.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

    Optional<Courses> findByCourseName(String CourseName);

    Optional<Courses> findByDescription(String description);

    List<Courses> findByCourseNameContaining(String searchTerm);

    List<Courses> findByDescriptionContaining(String searchTerm);

    List<Courses> findByStudentsId(int studentId);
}
