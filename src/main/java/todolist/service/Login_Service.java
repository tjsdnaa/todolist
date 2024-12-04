package todolist.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import todolist.dto.LoginRequest;
import todolist.repository.Login_Repository;


@Service
public class Login_Service {

    private final Login_Repository login_repository;


    public Login_Service(Login_Repository loginRepository) {
        login_repository = loginRepository;
    }

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
