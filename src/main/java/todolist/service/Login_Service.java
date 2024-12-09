package todolist.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import todolist.dto.LoginRequest;
import todolist.entity.TodoList;
import todolist.entity.User;
import todolist.repository.Login_Repository;

import java.util.List;


@Service
public class Login_Service {

    private final Login_Repository login_repository;
    public Login_Service(Login_Repository loginRepository) {
        login_repository = loginRepository;
    }


    //로그인 상태인지 확인
    public User isLogined(HttpSession httpSession) {
        if(login_repository.findByUserId((String) httpSession.getAttribute("userId")).isPresent()){
            return login_repository.findByUserId((String) httpSession.getAttribute("userId")).get();
        }
        return null;
    }



                                                //로그인 인증
    public boolean authenticate(LoginRequest loginRequest, HttpSession httpSession){
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        if(login_repository.findByUserId(userId).isPresent()){
            User u = login_repository.findByUserId(userId).get();

            if(u.getUserId().equals(userId) && u.getPassword().equals(password)){
                httpSession.setAttribute("userId",loginRequest.getUserId());
                return true;
            }
        }

        return false;
    }
}
