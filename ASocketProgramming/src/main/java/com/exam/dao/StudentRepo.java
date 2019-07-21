package com.exam.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.Student;
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

}
