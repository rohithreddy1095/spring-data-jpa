package com.school.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.spring.data.jpa.entity.Gaurdian;
import com.school.spring.data.jpa.entity.Student;

@SpringBootTest
// @DataJpaTest : should use this as this will create the data..chek the
// operations and then flush once the transaction is done !
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    // @Test
    // public void saveStudent() {
    // Student studentRohhh =
    // Student.builder().emailId("rohithreddy1095@gmail.com").firstName("Rohith")
    // .lastName("Reddy").gaurdianMailId("gaurdian@gmail.com").gaurdianMobile("9999999999")
    // .gaurdianName("Gaurd Mahendra").build();

    // studentRepository.save(studentRohhh);
    // }

    @Test
    public void saveStudent() {
        Gaurdian gaurdian = Gaurdian.builder().mailId("gaurdian@gmail.com").mobile("9999999999").name("Gaurd Mahendra")
                .build();
        Student studentRohhh = Student.builder().emailId("rohithreddy1095.mrr@gmail.com").firstName("Rohhh")
                .lastName("Rohhh").gaurdian(gaurdian).build();

        studentRepository.save(studentRohhh);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentsList = studentRepository.findAll();
        System.out.println("students List : " + studentsList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentByFirstName = studentRepository.findByFirstName("Rohhh");
        System.out.println("studentByFirstName : " + studentByFirstName);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGaurdianName("Gaurd Mahendra");
        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress(
                "rohithreddy1095@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress(
                "rohithreddy1095.mrr@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative(
                "rohithreddy1095@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "rohithreddy1095@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentFirstNameByEmailId(
                "Reddy",
                "rohithreddy1095.mrr@gmail.com");
    }
}
