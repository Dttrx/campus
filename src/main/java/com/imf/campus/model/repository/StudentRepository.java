package com.imf.campus.model.repository;

import com.imf.campus.model.entity.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, Long> {
}
