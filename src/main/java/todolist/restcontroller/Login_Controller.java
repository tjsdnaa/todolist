package todolist.restcontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todolist.dto.LoginRequest;
import todolist.service.Login_Service;

@RestController
@RequestMapping
public class Login_Controller {
    private final Login_Service login_service;

    public Login_Controller(Login_Service loginService) {
        login_service = loginService;
    }

    @PostMapping("/login")
    public boolean handleLogin(@RequestBody LoginRequest loginRequest,HttpSession httpSession){
        return login_service.authenticate(loginRequest,httpSession);
    }

    @GetMapping("/logout")
    public boolean logout(HttpSession httpSession){
        httpSession.invalidate();
        return false;
    }
}