package todolist.service;

import org.springframework.stereotype.Service;
import todolist.repository.Login_Repository;

import java.util.stream.Collectors;

@Service
public class Login_Service {

    private final Login_Repository login_repository;


    public Login_Service(Login_Repository loginRepository) {
        login_repository = loginRepository;
    }

    public boolean authenticate(String user_id,String password){
        if(login_repository.findByUser_id(user_id).isPresent()){
            return login_repository.findByUser_id(user_id).get().getPassword().equals(password);
        }

        return false;
    }
}
