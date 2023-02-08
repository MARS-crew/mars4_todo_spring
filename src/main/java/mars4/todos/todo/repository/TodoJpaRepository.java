package mars4.todos.todo.repository;

import mars4.todos.todo.domain.Todo;
import mars4.todos.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUser(User user);
}
