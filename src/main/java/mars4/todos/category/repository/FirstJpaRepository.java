package mars4.todos.category.repository;

import mars4.todos.category.domain.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstJpaRepository extends JpaRepository<FirstCategory, Long> {
}