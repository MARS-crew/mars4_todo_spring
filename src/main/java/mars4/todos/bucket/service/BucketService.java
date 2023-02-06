package mars4.todos.bucket.service;

import mars4.todos.coommon.dto.RequestResponseDto;

public interface BucketService {
    RequestResponseDto<?> saveBucket();
    RequestResponseDto<?> findOneBucket();
    RequestResponseDto<?> findAllBucket();
    RequestResponseDto<?> updateBucket();
    RequestResponseDto<?> deleteBucket();
}
