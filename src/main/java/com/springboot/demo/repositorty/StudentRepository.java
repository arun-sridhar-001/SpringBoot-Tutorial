package com.springboot.demo.repositorty;

import com.springboot.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByName(String name);


    @Query(value = """
            select COUNT(s.id)
            from student s
            where s.name = :name
            """, nativeQuery = true)
    Long getStudentCount(@Param("name") String name);
}
