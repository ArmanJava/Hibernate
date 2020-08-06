package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.dao.TutorRepository;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository ;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }
    @GetMapping("/tutors")
    public String getTutorPage(Model model) {
        model.addAttribute("tutors", tutorRepository.findTutors());
        return "tutor";
    }

//    @PostMapping("/students")
//    public String sendForm(@ModelAttribute Student student) {
//        System.out.println(student);
//        return "redirect:/";
//    }

}
