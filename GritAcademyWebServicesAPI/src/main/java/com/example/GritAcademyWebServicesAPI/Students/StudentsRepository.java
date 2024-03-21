package com.example.GritAcademyWebServicesAPI.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {


    Optional<Students> findByfName(String fName);
    Optional<Students> findBylName(String lName);

    Optional<Students> findByTown(String town);
    List<Students> findByCoursesId(int coursesID);


}
