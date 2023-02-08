package mars4.todos.category.dto;

import lombok.Data;
import mars4.todos.category.domain.FirstCategory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class FirstCategoryResponseDto {
    private Long idx;
    private String name;
    private Stream<Object> children;

    public FirstCategoryResponseDto(FirstCategory firstCategory) {
        this.idx = firstCategory.getIdx();
        this.name = firstCategory.getName();
        this.children = firstCategory.getSecondCategories().stream()
                .collect(Collectors.toList()).stream().map(secondCategory -> new SecondCategoryResponsedto(secondCategory));
    }
}
