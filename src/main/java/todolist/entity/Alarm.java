package todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Alarm {

    @Id
    private int alarmId;

    @ManyToOne
    private TodoList todoList;

    // Lombok이 자동으로 getter, setter를 생성
}
