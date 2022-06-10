package com.school.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.spring.data.jpa.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
