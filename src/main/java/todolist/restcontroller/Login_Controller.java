package todolist.restcontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todolist.service.Login_Service;

@RestController
@RequestMapping
public class Login_Controller {
    private final Login_Service login_service;

    public Login_Controller(Login_Service loginService) {
        login_service = loginService;
    }

    @PostMapping("/login")
    public boolean handleLogin(@RequestParam String user_id,
                              @RequestParam String password,
                              HttpSession httpSession,
                              Model model){
        if(login_service.authenticate(user_id,password)){
            httpSession.setAttribute("user_id",user_id);
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public boolean logout(HttpSession httpSession){
        httpSession.invalidate();
        return false;
    }

}
