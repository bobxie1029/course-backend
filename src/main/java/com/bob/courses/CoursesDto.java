package com.bob.courses;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoursesDto {
    int courseId;
    String courseName;
    String authorName;
    int durationInHours;
    String availability;

}
