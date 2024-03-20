package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class FirstController {

   @Autowired
    StudentService studentService;

    @GetMapping("/check")
    public ModelAndView check(Model m){
        List<Student> studentList = studentService.getStudentData();
        m.addAttribute("student",studentList);
        return new ModelAndView("First");

    }

    @GetMapping("/showData")
    public ModelAndView showData(Model model){
        ModelAndView modelAndView = new ModelAndView("second");
//        Map<String,String> map = new HashMap<>();
//        map.put("one","Hello");
//        map.put("two","data");

        model.addAttribute("check","test");
        return  modelAndView;
    }

    @GetMapping("/showStudentForm")
    public String showForm(Model model)
    {
        Student student = new Student();
        model.addAttribute("student",student);
        return "showStudentForm";   // it is a name of html file.
    }

    @PostMapping("/save")
    public String displayStudentData(Model model, @ModelAttribute("student") Student student){
        System.out.println("-------------------------- " + student.getName());
        model.addAttribute("student",student);
        return "showStudentData";
    }
}
