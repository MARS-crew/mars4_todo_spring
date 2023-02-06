package mars4.todos.bucket.repository;

import mars4.todos.bucket.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketJpaRepository extends JpaRepository<Bucket, Long> {
}
