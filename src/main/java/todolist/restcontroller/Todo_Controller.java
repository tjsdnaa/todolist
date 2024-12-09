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
    public List<TodoList> getAllList(@RequestParam(name = "id") String id){
        return todo_service.getAllList(id);
    }

    @GetMapping("/list/{i}")
    public TodoList getByList(@PathVariable("i") Integer i) {
        return todo_service.getByList(i);
    }

    @DeleteMapping("/list/{i}")
    public void deleteByList(@PathVariable("i") Integer i) {
        todo_service.deleteByList(i);
    }

    @PutMapping
    public boolean updateByList(@PathVariable("i") Integer i,@RequestBody TodoList list) {
        return todo_service.updateByList(i,list);
    }


    @PostMapping
    public TodoList createTodo(@RequestBody TodoList list){
        return todo_service.createTodo(list);
    }
}
