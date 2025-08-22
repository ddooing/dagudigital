package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class StudentService {
	
	 @Autowired
	    private StudentRepository studentRepository;



	    public void save(String name,String number) {

	    	Student s = new Student();

	        s.setName(name);
	        s.setNumber(number);

	        studentRepository.save(s);

	    }
	    
	    public List<Student> findAll() {

	        return studentRepository.findAll();
	    }
	    
	    public void deleteById(Integer id)
	    {
	    	studentRepository.deleteById(id);// 기본 메서드 
	    }
}
