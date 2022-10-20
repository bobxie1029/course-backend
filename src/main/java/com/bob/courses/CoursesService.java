package com.bob.courses;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class CoursesService {
    private CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<CoursesDto> getAllCourses() {
        List<CoursesDto> coursesDtos = new ArrayList<>();
        List<CoursesEntity> coursesEntities = coursesRepository.findAll();
        for (CoursesEntity entity : coursesEntities) {
            CoursesDto coursesDto = new CoursesDto();
            coursesDto.setCourseId(entity.getCourseId());
            coursesDto.setCourseName(entity.getCourseName());
            coursesDto.setAuthorName(entity.getAuthorName());
            coursesDto.setDurationInHours(entity.getDurationInHours());
            coursesDto.setAvailability(entity.getAvailability());
            coursesDtos.add(coursesDto);
        }
        return coursesDtos;
    }

    public CoursesDto createCourse(@RequestBody CoursesDto body) {
        CoursesEntity entity = new CoursesEntity();
        entity.setCourseId(body.getCourseId());
        entity.setCourseName(body.getCourseName());
        entity.setAuthorName(body.getAuthorName());
        entity.setDurationInHours(body.getDurationInHours());
        entity.setAvailability(body.getAvailability());
        coursesRepository.save(entity);

        CoursesDto coursesDto = new CoursesDto();
        coursesDto.setCourseId(entity.getCourseId());
        coursesDto.setCourseName(entity.getCourseName());
        coursesDto.setAuthorName(entity.getAuthorName());
        coursesDto.setDurationInHours(entity.getDurationInHours());
        coursesDto.setAvailability(entity.getAvailability());
        return coursesDto;
    }
    public CoursesDto deleteCourses(long courseId){
        CoursesDto coursesDto = new CoursesDto();
       Optional<CoursesEntity> coursesEntityOptional = coursesRepository.findById(courseId);
        if(coursesEntityOptional.isPresent()){
            log.info("The course with this id " + courseId + " found");
            CoursesEntity coursesEntity = coursesEntityOptional.get();
            coursesRepository.delete(coursesEntity);
            coursesDto.setCourseId(coursesEntity.getCourseId());
            coursesDto.setCourseName(coursesEntity.getCourseName());
            coursesDto.setAuthorName(coursesEntity.getAuthorName());
            coursesDto.setDurationInHours(coursesEntity.getDurationInHours());
            coursesDto.setAvailability(coursesEntity.getAvailability());
        }
        else{
                        log.info("The course with this id " + courseId + " doesn't exist in database");
                        throw new NoSuchCourseExistsException(courseId + " doesn't exist in database");
        }
        return coursesDto;


    }

}


