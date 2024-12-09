package todolist.restcontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import todolist.dto.LoginRequest;
import todolist.entity.User;
import todolist.service.Login_Service;

@RestController
public class Login_Controller {
    private final Login_Service login_service;

    public Login_Controller(Login_Service loginService) {
        login_service = loginService;
    }

    //로그인 체크
    @GetMapping("/login")
    public User login_check(HttpSession httpSession){
        return login_service.isLogined(httpSession);
    }

    //로그인 하기
    @PostMapping("/login")
    public boolean handleLogin(@RequestBody LoginRequest loginRequest, HttpSession httpSession){
        return login_service.authenticate(loginRequest,httpSession);
    }

    //로그아웃
    @GetMapping("/logout")
    public boolean logout(HttpSession httpSession){
        httpSession.invalidate();
        return false;
    }
}