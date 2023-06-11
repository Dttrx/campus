package com.imf.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.imf.campus.model.CampusPerson;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(
            mappedBy = "teacher",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "teacher"})
    private List<Subject> subjects;

    @SuppressWarnings("unused")
    @Builder
    public Teacher(String name, User user, long id) {
        super(name, user);
        this.id = id;
    }
}
