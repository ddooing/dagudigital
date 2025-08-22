package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



@Controller
public class StudentController {

	@Autowired

    private StudentService studentService;   // 서비스 자동 연결

    

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("students", studentService.findAll());

        return "index";               // index.html 보여주기

    }

    @PostMapping("/students")

    public String create(@RequestParam("name") String name, 
    		@RequestParam("number") String number) {

    	studentService.save(name,number);        // 글자 저장

        return "redirect:/";

    }
    
    
//    // delete 인데 get 방식 -> restful 위배  
//    @GetMapping("/students/delete")
//    public String deleteStudent(@RequestParam("id") Integer id) {
//
//    	studentService.deleteById(id);
//
//        return "redirect:/";              
//
//    }
    
    //가장 큰 차이 @GetMapping으로 전혀 문제없이 동작하지만 REST ful 에 위배된다.
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

    
    
}
