package kz.engbro.controller;

import kz.engbro.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pair")
public class PairController {

    private final PairService pairService;

    @Autowired
    public PairController(PairService pairService) {
        this.pairService = pairService;
    }

    @GetMapping
    public String pairs(Model model) {
        model.addAttribute("pairs", pairService.findAll());
        return "pair";
    }
}
