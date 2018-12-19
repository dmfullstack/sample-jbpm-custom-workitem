package com.company.workflowservice.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/demo")
    public String doDemo(Model model) {
        return "demo";
    }
}
