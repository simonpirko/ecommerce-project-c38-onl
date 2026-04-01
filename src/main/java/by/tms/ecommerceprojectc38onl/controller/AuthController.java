package by.tms.ecommerceprojectc38onl.controller;

import by.tms.ecommerceprojectc38onl.dto.UserCreateDTO;
import by.tms.ecommerceprojectc38onl.dto.UserLoginDTO;
import by.tms.ecommerceprojectc38onl.dto.UserResponseDTO;
import by.tms.ecommerceprojectc38onl.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserCreateDTO());
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginDto", new UserLoginDTO());
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserCreateDTO dto,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            userService.register(dto);
            return "redirect:/auth/login";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "registration";
        }
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginDto") UserLoginDTO dto,
                        BindingResult bindingResult,
                        Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            UserResponseDTO user = userService.login(dto);
            session.setAttribute("currentUser", user);
            return "redirect:/";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (Objects.nonNull(session)) {
            session.invalidate();
        }
        return "redirect:/auth/login";
    }
}