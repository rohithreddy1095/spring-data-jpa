package com.school.spring.data.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.spring.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstame);

    List<Student> findByGaurdianName(String gaurdianName);

    // JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Native
    @Query(value = "SELECT * FROM tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    // Native Named Param
    @Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentFirstNameByEmailId(String firstName, String emailId);
}
