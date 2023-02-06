package mars4.todos.category.repository;

import mars4.todos.category.domain.ThirdCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdJpaRepository extends JpaRepository<ThirdCategory, Long> {
}
