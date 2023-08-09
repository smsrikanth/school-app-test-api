package org.schoolapp.schoolapp.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    
    @GetMapping(value = "/getStudentInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonFromFile() {
        try {
            // Change the file path to the actual path of your JSON file
            String filePath = "/Users/harshakota/Desktop/WM/workspace/src/main/resources/student-sample.json";

            Path path = Paths.get("src","main","resources","student-sample.json");
            byte[] fileBytes = Files.readAllBytes(path);
            String fileContent = new String(fileBytes);
 
            // Parse the file content as a JSON object
            JSONObject jsonObject = new JSONObject(fileContent);
System.out.println(jsonObject);
            // Create a ResponseEntity with the JSON object and OK status
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error reading JSON file");
        }
    }


    @GetMapping("/")
    public String welcome() {
        return "Hello WelcomeHK";
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
