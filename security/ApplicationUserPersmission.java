package com.example.demo.security;

public enum ApplicationUserPersmission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");
    private final String persmission;

    ApplicationUserPersmission(String persmission) {
        this.persmission = persmission;
    }

    public String getPersmission() {
        return persmission;
    }
}
