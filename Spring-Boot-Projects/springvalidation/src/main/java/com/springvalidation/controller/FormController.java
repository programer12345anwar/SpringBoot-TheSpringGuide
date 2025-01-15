package com.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springvalidation.entities.FormData;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "form"; // form.html
    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute("formData") FormData formData) {
        System.out.println("Form submitted: " + formData);
        // Add logic to handle form submission, like saving data to a database
        return "success"; // success.html (a confirmation page)
    }
}
