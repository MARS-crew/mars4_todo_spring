package mars4.todos.bucket.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.bucket.domain.Bucket;
import mars4.todos.bucket.dto.RequestUpdateBucketDto;
import mars4.todos.bucket.dto.RequestUpdateStateBucketDto;
import mars4.todos.bucket.repository.BucketJpaRepository;
import mars4.todos.category.domain.ThirdCategory;
import mars4.todos.category.repository.ThirdJpaRepository;
import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.user.domain.User;
import mars4.todos.user.repository.UserJpaRepository;
import mars4.todos.user.service.UserServiceImpl;
import mars4.todos.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService{
    private final BucketJpaRepository bucketJpaRepository;
    private final ThirdJpaRepository thirdJpaRepository;
    private final UserJpaRepository userJpaRepository;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RequestResponseDto<?> saveBucket(Long id) {
        try{
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if(findUser.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            Optional<ThirdCategory> findThirdCategory = thirdJpaRepository.findById(id);

            if(findThirdCategory.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Third Category를 찾을 수 없습니다.", null);
            }

            Bucket bucket = Bucket.builder()
                    .user(findUser.get())
                    .text(findThirdCategory.get().getName())
                    .thirdCategory(findThirdCategory.get())
                    .comYn(false)
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "Bucket를 생성하였습니다.", bucketJpaRepository.save(bucket));
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findOneBucket(Long id) {
        try {
            Optional<Bucket> findBucket = bucketJpaRepository.findById(id);

            if(findBucket.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket를 찾을 수 없습니다.", null);
            }

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 조회하였습니다.", findBucket.get());
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findAllBucket() {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if(findUser.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }
            List<Bucket> bucketList = bucketJpaRepository.findAllByUser(findUser.get());
            System.out.println("1" + bucketList);
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS,"버킷을 조회하였습니다.", bucketList);
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> updateBucket(RequestUpdateBucketDto dto, Long id) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if(findUser.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            Optional<Bucket> findBucket = bucketJpaRepository.findById(id);

            if(findBucket.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket를 찾을 수 없습니다.", null);
            }

            if (!(findBucket.get().getUser().equals(findUser.get()))) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket에 대한 권한이 없습니다.", null);
            }

            findBucket.get().setText(dto.getText());
            bucketJpaRepository.save(findBucket.get());

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS,"버킷을 수정하였습니다.", true);
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> updateStateBucket(RequestUpdateStateBucketDto dto, Long id) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if(findUser.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            Optional<Bucket> findBucket = bucketJpaRepository.findById(id);

            if(findBucket.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket를 찾을 수 없습니다.", null);
            }

            if (!(findBucket.get().getUser().equals(findUser.get()))) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket에 대한 권한이 없습니다.", null);
            }

            findBucket.get().setComYn(dto.isState());
            bucketJpaRepository.save(findBucket.get());

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS,"버킷 상태를 수정하였습니다.", true);
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> deleteBucket(Long id) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if(findUser.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            Optional<Bucket> findBucket = bucketJpaRepository.findById(id);

            if(findBucket.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket를 찾을 수 없습니다.", null);
            }

            if (!(findBucket.get().getUser().equals(findUser.get()))) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Bucket에 대한 권한이 없습니다.", null);
            }

            bucketJpaRepository.delete(findBucket.get());
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS,"버킷을 삭제하였습니다.", true);
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

}
