package mars4.todos.category.dto;

import lombok.Data;
import mars4.todos.category.domain.SecondCategory;
import mars4.todos.category.domain.ThirdCategory;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SecondCategoryResponsedto {
    private Long idx;
    private String name;
    private List<ThirdCategory> children;

    public SecondCategoryResponsedto(SecondCategory secondCategory) {
        this.idx = secondCategory.getIdx();
        this.name = secondCategory.getName();
        this.children = secondCategory.getThirdCategories().stream()
                .collect(Collectors.toList());
    }


}
