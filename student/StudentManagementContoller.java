package com.example.demo.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/student")
public class StudentManagementContoller {
    private static final List<Student> STUDENT_LIST= Arrays.asList(
            new Student(1,"Anna"),
            new Student(2,"Gleb"),
            new Student(3,"vika")
    );
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getStudentList(){
        System.out.println("getStudentList");
        return STUDENT_LIST;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registeredNewStudents(@RequestBody Student student){
        System.out.println("registeredNewStudents");
        System.out.println(student);

    }
    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);

    }
    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public  void updateStudents(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("%s %s",studentId,student));

    }
}
