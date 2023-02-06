package mars4.todos.bucket.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.bucket.repository.BucketJpaRepository;
import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService{
    private final BucketJpaRepository bucketJpaRepository;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RequestResponseDto<?> saveBucket() {
        return null;
    }

    @Override
    public RequestResponseDto<?> findOneBucket() {
        return null;
    }

    @Override
    public RequestResponseDto<?> findAllBucket() {
        return null;
    }

    @Override
    public RequestResponseDto<?> updateBucket() {
        return null;
    }

    @Override
    public RequestResponseDto<?> deleteBucket() {
        return null;
    }
}
