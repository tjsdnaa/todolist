package todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.entity.TodoList;
import todolist.repository.Todo_Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Todo_Service {
    private final Todo_Repository todo_repository;

    public Todo_Service(Todo_Repository todoRepository) {
        todo_repository = todoRepository;
    }


    // user_id에 해당하는 todolist 전체 출력 및 마감일에 따라 리스트 정렬
    public List<TodoList> getAllList(String id){
        List<TodoList> todo = todo_repository.findByUserId(id);

        Collections.sort(todo, (o1, o2) -> o1.getClosingDate().compareTo(o2.getClosingDate()));

        return todo;
    }

    public TodoList getByList(Integer i){
        return todo_repository.findByListId(i);
    }

    @Transactional
    public void deleteByList(Integer i){
        todo_repository.deleteByListId(i);
    }

    @Transactional
    public boolean updateByList(Integer i,TodoList list){
        if(todo_repository.findById(i).isPresent()){
            TodoList todo = todo_repository.findById(i).get();
            todo.setTitle(list.getTitle());
            todo.setContent(list.getContent());
        } else{
            createTodo(list);
        }
        return true;
    }

    public TodoList createTodo(TodoList list) {
        return todo_repository.save(list);
    }
}
