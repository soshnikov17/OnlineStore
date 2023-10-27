package com.example.OnlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/start")
    public String getStartPage() {
        return "start";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
}
