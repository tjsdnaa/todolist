package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.entity.TodoList;

@Repository
public interface Todo_Repository extends JpaRepository<TodoList,Integer> {
}
