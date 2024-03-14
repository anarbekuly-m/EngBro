package kz.engbro.controller;

import kz.engbro.entity.enumuration.GuessLevel;
import kz.engbro.entity.model.Guess;
import kz.engbro.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guess")
public class GuessController {

    private final GuessService guessService;

    @Autowired
    public GuessController(GuessService guessService) {
        this.guessService = guessService;
    }

    @GetMapping
    public String guess() {
        return "guess";
    }

    @GetMapping("/standard")
    public String standard(Model model) {
        List<Guess> all = guessService.findAll(GuessLevel.STANDARD);
        model.addAttribute("list", all);
        return "guessgame";
    }

    @GetMapping("/hard")
    public String hard(Model model) {
        List<Guess> all = guessService.findAll(GuessLevel.HARD);
        model.addAttribute("list", all);
        return "guessgame";
    }
}
