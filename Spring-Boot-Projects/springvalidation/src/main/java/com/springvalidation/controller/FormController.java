package com.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springvalidation.entities.FormData;

import jakarta.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        System.out.println("opening form");
        model.addAttribute("formData", new FormData());
        return "form"; // form.html
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("formData") FormData formData,BindingResult result) {
        if(result.hasErrors()) {
            System.out.println(result);
            return "form";
        }
        System.out.println("Form submitted: " + formData);
        // Add logic to handle form submission, like saving data to a database
        return "success"; // success.html (a confirmation page)
    }
}
