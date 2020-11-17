package com.example.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.security.ApplicationUserPersmission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));
    private final Set<ApplicationUserPersmission> permissions;

    ApplicationUserRole(Set<ApplicationUserPersmission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPersmission> getPermissions() {
        return permissions;
    }


    public Set<SimpleGrantedAuthority> getGrantedAuthoritySet() {
        Set<SimpleGrantedAuthority> permissions=getPermissions()
                .stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPersmission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        System.out.println(permissions);
        return permissions;
    }
}
