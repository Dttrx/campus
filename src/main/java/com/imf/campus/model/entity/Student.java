package com.imf.campus.model.entity;

import com.imf.campus.model.CampusPerson;
import jakarta.persistence.*;
import lombok.*;

// lombok
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
// spring data
@Entity
public class Student extends CampusPerson {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Builder
    public Student(String name, User user, long id) {
        super(name, user);
        this.id = id;
    }
}
