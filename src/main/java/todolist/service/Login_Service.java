package todolist.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import todolist.dto.LoginRequest;
import todolist.repository.Login_Repository;


@Service
public class Login_Service {

    private final Login_Repository login_repository;

    //로그인 상태인지 확인
    public boolean isLogined(HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute("userId");

        return userId != null && !userId.isEmpty();
    }

    //회원가입
    public Login_Service(Login_Repository loginRepository) {
        login_repository = loginRepository;
    }

    //로그인 인증
    public boolean authenticate(LoginRequest loginRequest, HttpSession httpSession){
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        if(login_repository.findByUserId(userId).isPresent()){
            httpSession.setAttribute("userId",loginRequest.getUserId());
            return login_repository.findByUserId(userId).get().getPassword().equals(password);
        }

        return false;
    }
}
