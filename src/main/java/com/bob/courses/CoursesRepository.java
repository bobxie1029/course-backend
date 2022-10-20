package com.bob.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity,Integer> {
    List<CoursesEntity> findByCourseId(int courseId);
}
