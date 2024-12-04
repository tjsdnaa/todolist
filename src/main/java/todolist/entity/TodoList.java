package todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class TodoList {

    @Id
    private Integer listId;
    private String title;
    private String content;
    private Date closingDate;

    private String userId;

}
