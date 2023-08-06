package org.schoolapp.schoolapp.user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.UrlTag;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @GetMapping("/student")
    public ResponseEntity<ApiResponse<List<Student>>> hello() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            students.add(new Student(("student" + i), ("student" + i), 30 + i, "V", "B", "http://test-image-s3-bucket.com/" + "student" + i + "/student" + i + ".jpeg"));
        }
        log.info("Students {}", students);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), 2000, "Student List", students));
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello Welcome";
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class ApiResponse<T> {
    int httpStatusCode;
    String httpMessage;
    int statusCode;
    String description;
    T data;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
class Student {
    String name;
    String username;
    int age;
    String standard;
    String section;
    String photo;
}
