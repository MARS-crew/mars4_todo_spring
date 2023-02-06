package mars4.todos.category.service;

import mars4.todos.category.dto.RequestSaveCategoryDto;
import mars4.todos.coommon.dto.RequestResponseDto;

public interface CategoryService {
    RequestResponseDto<?> saveFirstCategory(RequestSaveCategoryDto dto);
    RequestResponseDto<?> saveSecondCategory(RequestSaveCategoryDto dto, Long id);
    RequestResponseDto<?> saveThirdCategory(RequestSaveCategoryDto dto, Long id);
    RequestResponseDto<?> findCategory();
}
