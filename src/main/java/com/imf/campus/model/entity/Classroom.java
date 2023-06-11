package com.imf.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// spring data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"letter", "degree_id"}
        )
})
public class Classroom {
    @Id
    @Column(name = "classroom_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private char letter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "degree_id",
            referencedColumnName = "degree_id"
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "classrooms"})
    private Degree degree;
}
