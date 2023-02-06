package mars4.todos.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.coommon.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_1st_category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FirstCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "1st_idx")
    private Long idx;

    @Column(name = "1st_name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "1st_idx")
    private List<SecondCategory> secondCategoryList = new ArrayList<>();
}
