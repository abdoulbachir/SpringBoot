package com.bachir.cruddemo.dao;

import com.bachir.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

        //save/add student to database
        void save(Student theStudent);

        //Find student by id from database
        Student findByID(Integer id);

        //Query all the student
        List<Student> findAll();

        //Query student by lastName
        List<Student> findByLastName(String theLastName);

        //Update student
        void update(Student student);

        //Delete student
        void delete(Integer id);

        //Delete All students
        int deleteAll();
}
