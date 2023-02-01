package mars4.todos.user.service;

import mars4.todos.coommon.dto.RequestResponseDto;

public interface UserService {
    RequestResponseDto<?> save(RequestResponseDto dto);

    RequestResponseDto<?> login(RequestResponseDto dto);
}
