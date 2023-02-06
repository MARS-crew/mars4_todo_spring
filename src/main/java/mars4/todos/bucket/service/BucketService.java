package mars4.todos.bucket.service;

import mars4.todos.bucket.dto.RequestUpdateBucketDto;
import mars4.todos.bucket.dto.RequestUpdateStateBucketDto;
import mars4.todos.coommon.dto.RequestResponseDto;

public interface BucketService {
    RequestResponseDto<?> saveBucket(Long id);
    RequestResponseDto<?> findOneBucket(Long id);
    RequestResponseDto<?> findAllBucket();
    RequestResponseDto<?> updateBucket(RequestUpdateBucketDto dto, Long Id);
    RequestResponseDto<?> updateStateBucket(RequestUpdateStateBucketDto dto, Long Id);
    RequestResponseDto<?> deleteBucket(Long id);
}
