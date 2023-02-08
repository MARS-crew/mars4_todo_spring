package mars4.todos.category.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.common.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "1st_idx")
    private FirstCategory firstCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "secondCategory")
    private List<ThirdCategory> thirdCategories = new ArrayList<>();
}
