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


    // user_id에 해당하는 todolist 전체 출력
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
    //키워드로 타이틀 찾기
    public List<TodoList> findByTitleContaining(String keyword){
        return todo_repository.findByTitleContaining(keyword);
    }

    public TodoList createTodo(TodoList list) {
        return todo_repository.save(list);
    }
}
