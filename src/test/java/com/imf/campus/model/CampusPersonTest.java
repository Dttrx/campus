package com.imf.campus.model;

import com.imf.campus.model.entity.Student;
import com.imf.campus.model.entity.Teacher;
import com.imf.campus.model.entity.User;
import com.imf.campus.model.repository.StudentRepository;
import com.imf.campus.model.repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CampusPersonTest {
    @Autowired
    StudentRepository sRepo;
    @Autowired
    TeacherRepository tRepo;

    @Test
    public void addCampusPerson() {
        Student s = Student.builder()
                .name("Lucía Ortíz Nuñez")
                .user(User.builder()
                        .username("lusía")
                        .email("lusia@ortiz.com")
                        .password("lon23")
                        .build())
                .build();

        Teacher t = Teacher.builder()
                .name("Carlos Rufiangel García")
                .user(User.builder()
                        .username("crufi")
                        .email("carlos@rufi.com")
                        .password("crg23")
                        .teacher(true)
                        .build())
                .build();

        sRepo.save(s);
        tRepo.save(t);

        Assertions.assertEquals(s, sRepo.findById(s.getId()).orElse(Student.builder().build()));
        Assertions.assertEquals(t, tRepo.findById(t.getId()).orElse(Teacher.builder().build()));
    }

    @Test
    public void findAllCampusPerson() {
        System.out.println(sRepo.findAll());
        System.out.println(tRepo.findAll());
    }
}