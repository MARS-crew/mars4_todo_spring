package mars4.todos.category.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.category.dto.RequestSaveCategoryDto;
import mars4.todos.category.repository.FirstJpaRepository;
import mars4.todos.category.repository.SecondJpaRepository;
import mars4.todos.category.repository.ThirdJpaRepository;
import mars4.todos.coommon.dto.RequestResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final FirstJpaRepository firstJpaRepository;
    private final SecondJpaRepository secondJpaRepository;
    private final ThirdJpaRepository thirdJpaRepository;

    @Override
    public RequestResponseDto<?> saveFirstCategory(RequestSaveCategoryDto dto) {
        return null;
    }

    @Override
    public RequestResponseDto<?> saveSecondCategory(RequestSaveCategoryDto dto, Long id) {
        return null;
    }

    @Override
    public RequestResponseDto<?> saveThirdCategory(RequestSaveCategoryDto dto, Long id) {
        return null;
    }

    @Override
    public RequestResponseDto<?> findCategory() {
        return null;
    }
}
