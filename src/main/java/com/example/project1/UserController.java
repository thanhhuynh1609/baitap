package com.example.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/userDetail")
    public String getUserDetail(Model model) {
        // Hardcode thông tin người dùng
        model.addAttribute("username", "Le Anh Bao");
        model.addAttribute("email", "leanhbabo@gmail.com");
        model.addAttribute("phone", "0878112334");
        model.addAttribute("address", "29, Truong Son, Hoa Tho Tay, Cam Le, Da Nang");

        return "userDetail"; // Trả về file userDetail.html trong thư mục templates
    }
}
