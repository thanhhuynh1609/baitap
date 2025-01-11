package com.example.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project1.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        // Tạo danh sách ban đầu
        users.add(new User("Le Anh Bao", "leanhbao@gmail.com", "0878112334", "29, Truong Son, Hoa Tho Tay, Cam Le, Da Nang"));
        users.add(new User("Huynh Thanh", "huynhthanh@gmail.com", "0977123456", "15, Nguyen Van Linh, Hai Chau, Da Nang"));
        users.add(new User("Huynh Van Hop", "hophuynh@gmail.com", "0977123333", "23, Le Van Luyen, Hai Chau, Da Nang"));
    }

    // Hiển thị danh sách người dùng
    @GetMapping("/userDetail")
    public String getUserDetail(Model model) {
        model.addAttribute("users", users);
        return "userDetail";
    }

    // Hiển thị form thêm người dùng
    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUser";
    }

    // Xử lý thêm người dùng
    @PostMapping("/addUser")
    public String addUser(@RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String phone,
                          @RequestParam String address) {
        users.add(new User(username, email, phone, address));
        System.out.println("User Added:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);

        return "redirect:/userDetail";
    }

    // Hiển thị form chỉnh sửa thông tin người dùng
    @GetMapping("/editUser")
    public String editUserForm(@RequestParam String username, Model model) {
        User userToEdit = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        model.addAttribute("user", userToEdit);
        return "editUser";
    }

    // Xử lý cập nhật thông tin người dùng
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam String originalUsername,
                             @RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String phone,
                             @RequestParam String address) {
        for (User user : users) {
            if (user.getUsername().equals(originalUsername)) {
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone);
                user.setAddress(address);
                break;
            }
        }

        System.out.println("User Updated:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);

        return "redirect:/userDetail";
    }

    // Xử lý xóa người dùng
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("User Deleted: " + username);

        return "redirect:/userDetail";
    }
}
