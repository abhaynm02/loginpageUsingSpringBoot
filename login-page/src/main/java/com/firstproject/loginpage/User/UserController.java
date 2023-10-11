package com.firstproject.loginpage.User;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(name = "error", required = false) String error, Model model, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {

            if (error != null) {
                model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
            }
            return "login";
        }
        String username = authentication.getName();
        session.setAttribute("name", username);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}