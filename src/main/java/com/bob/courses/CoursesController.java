package com.bob.courses;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoursesController {
    private CoursesService coursesService;
    public CoursesController(CoursesService coursesService){
        this.coursesService = coursesService;
    }
    @GetMapping("listCourses")
    public List<CoursesDto> listAllCourses(){
        return coursesService.getAllCourses();
    }
    @PostMapping("/course")
    public CoursesDto postCourse(@RequestBody CoursesDto body){
        log.info("Returned Course Id " + body.getCourseId() + " with Course Name " + body.getCourseName() + " with Author Name " + body.getAuthorName() +
               " Duration In Hours " +  body.getDurationInHours() + " Availbility " + body.getAvailability());
        CoursesDto coursesDto = coursesService.createCourse(body);
        return coursesDto;
    }
    @DeleteMapping("/deleteCourse/{id}")
    public CoursesDto deleteCourse(@PathVariable("id") int id){
        return coursesService.deleteCourses(id);
    }
}
