package com.imf.campus.model.entity;

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
@Table(indexes = {
        @Index(
                name = "unique_username",
                unique = true,
                columnList = "username"
        ),
        @Index(
                name = "unique_email",
                unique = true,
                columnList = "email"
        ),
})
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(
            name = "pass",
            nullable = false
    )
    private String password;
    @Column(
            nullable = false,
            columnDefinition = "boolean default false"
    )
    private boolean isTeacher;
}