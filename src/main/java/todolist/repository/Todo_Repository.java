package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.entity.TodoList;
import todolist.entity.User;

import java.util.Optional;

@Repository
public interface Todo_Repository extends JpaRepository<TodoList,Integer> {
    TodoList findByListId(Integer listId);
}
