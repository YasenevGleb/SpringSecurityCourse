package com.example.demo.auth;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.demo.security.ApplicationUserRole.*;
@Repository("fake")
public class FakeApplicationDaoService implements ApplicationUserDAO {
    private PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();

    }
    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("annaanna",
                        passwordEncoder.encode("34bb"),
                        STUDENT.getGrantedAuthoritySet(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser("gleb",
                        passwordEncoder.encode("34cc"),
                        ADMINTRAINEE.getGrantedAuthoritySet(),
                true,
                true,
                true,
                        true
                ),
                new ApplicationUser("anton",
                        passwordEncoder.encode("34aa"),
                        ADMIN.getGrantedAuthoritySet(),
                        true,
                        true,
                        true,
                        true)

        );
        System.out.println(applicationUsers);
        return applicationUsers;



    }
}