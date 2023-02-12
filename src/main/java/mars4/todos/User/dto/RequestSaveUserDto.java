package mars4.todos.User.dto;

import lombok.Data;

@Data
public class RequestSaveUserDto {
    private String id;
    private String password;
    private String name;
}
