package com.Telusko.SpringSecurityEx.Controller;
import com.Telusko.SpringSecurityEx.Models.StudentEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<StudentEntity> Students = new ArrayList<>(List.of(
            new StudentEntity(1, "Shubham" , 80),
            new StudentEntity(2, "Sidhhesh" , 70)
    ));

    @GetMapping("/students")
    public List<StudentEntity> getAllStudents(){
        return Students;
    }

    @PostMapping("/students")
    public void CreateNewStudent(@RequestBody StudentEntity newstudent ){
         Students.add(newstudent);
    }

    @GetMapping("/csrf")
    public CsrfToken csrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
