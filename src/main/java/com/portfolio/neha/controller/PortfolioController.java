package com.portfolio.neha.controller;

import com.portfolio.neha.model.Sender;
import com.portfolio.neha.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortfolioController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sender", new Sender());
        return "index";
    }

    @PostMapping("/")
    public String send(@ModelAttribute("sender") Sender sender) {

        System.out.println("🔥 CONTROLLER HIT");

        emailService.sendEmail(
                sender.getName(),
                sender.getEmail(),
                sender.getMessage()
        );

        return "redirect:/?success";
    }
}