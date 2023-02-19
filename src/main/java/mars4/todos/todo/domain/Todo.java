package mars4.todos.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.coommon.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_todoes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "text")
    private String text;

    @Column(name = "comyn")
    private boolean comyn = false;

    public Todo(Long idx,String text) {
        this.idx = idx;
        this.text = text;
    }

    public void changeStatus(){
        this.comyn = !this.comyn;
    }
}