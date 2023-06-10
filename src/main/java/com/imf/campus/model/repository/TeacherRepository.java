package com.imf.campus.model.repository;

import com.imf.campus.model.entity.Teacher;
import org.springframework.data.repository.ListCrudRepository;

public interface TeacherRepository extends ListCrudRepository<Teacher, Long> {
}
