package com.portfolio.neha.controller;

import com.portfolio.neha.model.Sender;
import com.portfolio.neha.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

    @Autowired
    SenderService senderService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("sender", new Sender());
        return "index";
    }

    @PostMapping("/")
    public String send(@ModelAttribute("sender") Sender sender) {
        senderService.saveIdentity(sender);
        return "redirect:/";
    }
}
