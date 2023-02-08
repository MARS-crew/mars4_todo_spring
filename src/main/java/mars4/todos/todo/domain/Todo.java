package mars4.todos.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.common.domain.BaseTimeEntity;
import mars4.todos.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_todo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_idx")
    private Long idx;

    @Column()
    private String text;

    @Column()
    private boolean comYn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idx")
    private User user;
}
