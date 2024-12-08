package todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.entity.TodoList;
import todolist.repository.Todo_Repository;

import java.util.List;
import java.util.Optional;

@Service
public class Todo_Service {
    private final Todo_Repository todo_repository;

    public Todo_Service(Todo_Repository todoRepository) {
        todo_repository = todoRepository;
    }


    // id에 해당하는 todolist 전체 출력
    public List<TodoList> getAllList(String id){
        return todo_repository.findByUserId(id);
    }

    public TodoList getByList(Integer i){
        return todo_repository.findByListId(i);
    }

    @Transactional
    public void deleteByList(Integer i){
        todo_repository.deleteByListId(i);
    }


    public TodoList createTodo(TodoList list){
        return todo_repository.save(list);
    }
    public void deleteTodo(TodoList list){
        todo_repository.deleteById(list.getListId());
    }
}
