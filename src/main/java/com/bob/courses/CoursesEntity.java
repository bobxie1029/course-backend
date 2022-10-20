package com.bob.courses;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course")
public class CoursesEntity {
    @Id
     int courseId;
    String courseName;
    String authorName;
    int durationInHours;
    String availability;

}
