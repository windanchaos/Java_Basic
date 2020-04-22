package com.chaosbom.repository;

import com.chaosbom.entity.Student;

import java.util.List;

public interface ClassesRepository {
    List<Student> findByID(int id);
}
