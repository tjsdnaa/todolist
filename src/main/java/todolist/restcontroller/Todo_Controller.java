package todolist.restcontroller;

import org.springframework.web.bind.annotation.*;
import todolist.entity.TodoList;
import todolist.service.Todo_Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoList")
public class Todo_Controller {

    private final Todo_Service todo_service;

    public Todo_Controller(Todo_Service todoService) {
        todo_service = todoService;
    }

    @GetMapping
    public Optional<TodoList> getAllList(){
        return todo_service.getAllList();
    }

    @PostMapping
    public TodoList createTodo(@RequestBody TodoList list){
        return todo_service.createTodo(list);
    }
    @DeleteMapping
    public void deleteTodo(@RequestBody TodoList list){
        todo_service.deleteTodo(list);
    }
}
