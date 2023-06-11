package com.imf.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// spring data
@Entity
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "subjects"})
    private Teacher teacher;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "degree_has_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "degree_id")
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "subjects"})
    private List<Degree> degrees;
}
