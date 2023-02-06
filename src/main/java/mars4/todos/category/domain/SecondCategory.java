package mars4.todos.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.coommon.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_2nd_category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecondCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "2nd_idx")
    private Long idx;

    @Column(name = "2nd_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "1st_idx")
    private FirstCategory firstCategory;
}
