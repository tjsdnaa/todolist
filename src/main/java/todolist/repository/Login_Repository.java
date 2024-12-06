package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.entity.User;

import java.util.Optional;

public interface Login_Repository extends JpaRepository<User,Integer> {
    Optional<User> findByUserId(String userId) ;
}
