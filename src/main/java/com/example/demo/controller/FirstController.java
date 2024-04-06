package com.example.demo.controller;


import com.example.demo.model.Faculty;
import com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/first")
public class FirstController {



   @GetMapping("/health")
   public String health(Model m){
       return "health";
   }

    @GetMapping("/showData")
    public ModelAndView showData(Model model){
        ModelAndView modelAndView = new ModelAndView("second");
        Map<String,String> map = new HashMap<>();
        map.put("one","Hello");
        map.put("two","data");

        model.addAttribute("check",map);
        return  modelAndView;
    }

    @GetMapping("/showFaculty")
    public String showFaculty(Model model){
        Faculty faculty = new Faculty();
        faculty.setName("Ajay");
        faculty.setEmail("abc@gmail.com");
        faculty.setAddress("GKP");
        model.addAttribute("faculty",faculty);
        return "faculty";
    }

    @GetMapping("/saveData")
    public String saveData(Model model){
       model.addAttribute("faculty",new Faculty());
       return "form";
    }

    @PostMapping("/greeting")
    public String showData(Model model,@ModelAttribute Faculty faculty){
       model.addAttribute("faculty",faculty);
       return "showRecord";
    }


   /* @GetMapping("/check")
    public ModelAndView check(Model m){
        List<Student> studentList = studentService.getStudentData();
        m.addAttribute("student",studentList);
        return new ModelAndView("first");

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
    }*/
}
