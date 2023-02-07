package mars4.todos.bucket.repository;

import mars4.todos.bucket.domain.Bucket;
import mars4.todos.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketJpaRepository extends JpaRepository<Bucket, Long> {
    List<Bucket> findAllByUser(User user);
}
