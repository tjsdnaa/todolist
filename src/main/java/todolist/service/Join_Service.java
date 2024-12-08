package todolist.service;

import org.springframework.stereotype.Service;
import todolist.entity.User;
import todolist.repository.Join_Repository;

import java.util.Optional;

@Service
public class Join_Service {
    private final Join_Repository join_repository;

    public Join_Service(Join_Repository joinRepository) {
        join_repository = joinRepository;
    }
    
    //db에 저장
    public boolean save(User user){

        if(!findbyByUserId(user)){
            join_repository.save(user);
            return true;
        } else{
            return false;
        }
    }

    //db에 동일한 아이디 있는지 찾기
    public boolean findbyByUserId(User user){
        Optional<User> u = join_repository.findByUserId(user.getUserId());

        if(u.isEmpty()){
            return false;
        } else{
            return true;
        }
    }
}
