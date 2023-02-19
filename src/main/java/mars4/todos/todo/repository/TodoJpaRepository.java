package mars4.todos.todo.repository;

import mars4.todos.User.domain.User;
import mars4.todos.todo.domain.Todo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoJpaRepository extends JpaRepository<Todo,Long> {

}
