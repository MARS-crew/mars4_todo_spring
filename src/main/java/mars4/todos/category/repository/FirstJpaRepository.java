package mars4.todos.category.repository;

import mars4.todos.category.domain.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FirstJpaRepository extends JpaRepository<FirstCategory, Long> {
    @Query("select f from FirstCategory f left join SecondCategory s on f.idx = s.firstCategory.idx left join ThirdCategory t on s.idx = t.secondCategory.idx")
    List<FirstCategory> findAll();
}