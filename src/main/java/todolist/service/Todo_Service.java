package todolist.service;

import org.springframework.stereotype.Service;
import todolist.entity.TodoList;
import todolist.repository.Todo_Repository;

import java.util.List;
import java.util.Optional;

@Service
public class Todo_Service {
    int id=1;
    private final Todo_Repository todo_repository;

    public Todo_Service(Todo_Repository todoRepository) {
        todo_repository = todoRepository;
    }

    public Optional<TodoList> getAllList(){
        return todo_repository.findById(id);
    }

    public TodoList createTodo(TodoList list){
        return todo_repository.save(list);
    }
    public void deleteTodo(TodoList list){
        todo_repository.deleteById(list.getListId());
    }
}
