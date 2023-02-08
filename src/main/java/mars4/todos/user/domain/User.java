package mars4.todos.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mars4.todos.common.domain.BaseTimeEntity;
import mars4.todos.common.dto.UserAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_idx")
    private Long idx;

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private UserAuthority authority;
}
