package mars4.todos.bucket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.category.domain.ThirdCategory;
import mars4.todos.coommon.domain.BaseTimeEntity;
import mars4.todos.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_bucket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bucket extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bucket_idx")
    private Long idx;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean comYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "3th_idx")
    private ThirdCategory thirdCategory;
}
