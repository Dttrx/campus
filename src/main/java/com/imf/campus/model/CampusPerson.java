package com.imf.campus.model;

import com.imf.campus.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
// spring data
@MappedSuperclass
@Table(indexes = @Index(
        name = "unique_full_name",
        unique = true,
        columnList = "full_name"
))
public class CampusPerson {
    @Column(nullable = false)
    private String fullName;
    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(name = "user_id")
    private User user;
}
