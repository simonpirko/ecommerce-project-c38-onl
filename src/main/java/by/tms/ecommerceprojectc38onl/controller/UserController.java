package by.tms.ecommerceprojectc38onl.controller;

import by.tms.ecommerceprojectc38onl.dto.UserResponseDTO;
import by.tms.ecommerceprojectc38onl.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model, HttpSession session) {
        UserResponseDTO currentUser = (UserResponseDTO) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        return "profile";
    }
}