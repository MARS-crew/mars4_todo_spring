package mars4.todos.category.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.common.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_3th_category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThirdCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "3th_idx")
    private Long idx;

    @Column(name = "3th_name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "2nd_idx")
    private SecondCategory secondCategory;
}
