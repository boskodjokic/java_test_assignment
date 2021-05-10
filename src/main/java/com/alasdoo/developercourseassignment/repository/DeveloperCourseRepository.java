package com.alasdoo.developercourseassignment.repository;

import com.alasdoo.developercourseassignment.entity.DeveloperCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Refactored queries so they are getting back correct lists.
 */

@Repository
public interface DeveloperCourseRepository extends JpaRepository<DeveloperCourse, Integer> {

    Optional<List<DeveloperCourse>> findByDeveloperCourseName(String developerCourseName);

    @Query(value = "SELECT dc.id, dc.classes_per_week, dc.cost_per_class, dc.developer_course_name " +
        "FROM developer_course dc " +
        "JOIN  student_developer_course  sdc ON dc.id = sdc.developer_course_id " +
        "JOIN Student s ON sdc.student_id = s.id " +
        "WHERE s.id = :id", nativeQuery = true)
    Optional<List<DeveloperCourse>> findDevCourseByStudentId(@Param("id") Integer id);

    @Query(value = "SELECT dc.id, dc.classes_per_week, dc.cost_per_class, dc.developer_course_name " +
        "FROM developer_course dc " +
        "JOIN  teacher_developer_course  tdc ON dc.id = tdc.developer_course_id " +
        "JOIN Teacher t ON tdc.teacher_id = t.id " +
        "WHERE t.id = :id", nativeQuery = true)
    Optional<List<DeveloperCourse>> findDevCourseByTeacherId(@Param("id") Integer id);

}
