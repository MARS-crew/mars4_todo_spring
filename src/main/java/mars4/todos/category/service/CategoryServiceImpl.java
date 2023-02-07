package mars4.todos.category.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.category.domain.FirstCategory;
import mars4.todos.category.domain.SecondCategory;
import mars4.todos.category.domain.ThirdCategory;
import mars4.todos.category.dto.RequestSaveCategoryDto;
import mars4.todos.category.repository.FirstJpaRepository;
import mars4.todos.category.repository.SecondJpaRepository;
import mars4.todos.category.repository.ThirdJpaRepository;
import mars4.todos.coommon.dto.RequestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final FirstJpaRepository firstJpaRepository;
    private final SecondJpaRepository secondJpaRepository;
    private final ThirdJpaRepository thirdJpaRepository;

    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public RequestResponseDto<?> saveFirstCategory(RequestSaveCategoryDto dto) {
        try{
            FirstCategory firstCategory = FirstCategory.builder()
                    .name(dto.getName())
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "First Category을 생성하였습니다.", firstJpaRepository.save(firstCategory));
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> saveSecondCategory(RequestSaveCategoryDto dto, Long id) {
        try{
            Optional<FirstCategory> findFirstCategory = firstJpaRepository.findById(id);

            if(findFirstCategory.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "First Category를 찾을 수 없습니다.", null);
            }

            SecondCategory secondCategory = SecondCategory.builder()
                    .name(dto.getName())
                    .firstCategory(findFirstCategory.get())
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "Second Category을 생성하였습니다.", secondJpaRepository.save(secondCategory));
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> saveThirdCategory(RequestSaveCategoryDto dto, Long id) {
        try{
            Optional<SecondCategory> findSecondCategory = secondJpaRepository.findById(id);

            if(findSecondCategory.isEmpty()){
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "Second Category를 찾을 수 없습니다.", null);
            }

            ThirdCategory thirdCategory = ThirdCategory.builder()
                    .name(dto.getName())
                    .secondCategory(findSecondCategory.get())
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "Third Category을 생성하였습니다.", thirdJpaRepository.save(thirdCategory));
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findCategory() {
        try{
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "조회 성공", firstJpaRepository.findAll());
        }catch (Exception e){
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }
}
