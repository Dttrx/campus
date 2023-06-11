package com.imf.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// spring data
@Entity
@Table(indexes = @Index(
        name = "unique_name",
        unique = true,
        columnList = "name"
))
public class Degree {
    @Id
    @Column(name = "degree_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(
            name = "abbr",
            nullable = false
    )
    private String abbreviature;
    @OneToMany(
            mappedBy = "degree",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "degree"})
    private List<Classroom> classrooms;
    @ManyToMany(mappedBy = "degrees")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "degrees"})
    private List<Subject> subjects;
}
