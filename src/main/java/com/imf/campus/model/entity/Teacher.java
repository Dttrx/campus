package com.imf.campus.model.entity;

import com.imf.campus.model.CampusPerson;
import jakarta.persistence.*;
import lombok.*;

// lombok
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
// spring data
@Entity
public class Teacher extends CampusPerson {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @SuppressWarnings("unused")
    @Builder
    public Teacher(String name, User user, long id) {
        super(name, user);
        this.id = id;
    }
}
