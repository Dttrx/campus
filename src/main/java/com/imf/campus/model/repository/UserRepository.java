package com.imf.campus.model.repository;

import com.imf.campus.model.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByIsTeacherTrue();
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
