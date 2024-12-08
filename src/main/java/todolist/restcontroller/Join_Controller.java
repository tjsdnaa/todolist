package todolist.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.entity.User;
import todolist.service.Join_Service;

@RestController
public class Join_Controller {
    private final Join_Service joinService;

    public Join_Controller(Join_Service joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public boolean id_join(@RequestBody User user){
        return joinService.save(user);
    }
}
