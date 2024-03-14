package kz.engbro.controller;

import kz.engbro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/level")
public class LevelController {

    private final QuestionService questionService;

    @Autowired
    public LevelController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String level(Model model) {
        model.addAttribute("questions", questionService.questionList());
        return "level";
    }

}
