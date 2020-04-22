package com.chaosbom.repository;

import com.chaosbom.entity.Student;

public interface StudentRepository {
    public Student findByID(int id);
}
