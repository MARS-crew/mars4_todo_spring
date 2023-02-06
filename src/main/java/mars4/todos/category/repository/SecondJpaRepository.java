package mars4.todos.category.repository;

import mars4.todos.category.domain.SecondCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondJpaRepository extends JpaRepository<SecondCategory, Long> {
}
