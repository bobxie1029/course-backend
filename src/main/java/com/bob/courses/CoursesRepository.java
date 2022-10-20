package com.bob.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity,Long> {
    List<CoursesEntity> findByCourseId(int courseId);
}
