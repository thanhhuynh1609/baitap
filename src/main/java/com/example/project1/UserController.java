package com.example.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.project1.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/userDetail")
    public String getUserDetail(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Le Anh Thanh", "leanhthanh@gmail.com", "0878112334", "29, Truong Son, Hoa Tho Tay, Cam Le, Da Nang"));
        users.add(new User("Nguyen Van Binh", "nguyenvanbinh@gmail.com", "0977123456", "15, Nguyen Van Linh, Hai Chau, Da Nang"));

        model.addAttribute("users", users);

        return "userDetail";
    }
}
