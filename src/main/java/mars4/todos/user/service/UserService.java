package mars4.todos.user.service;

import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.user.dto.RequestLoginUserDto;
import mars4.todos.user.dto.RequestSaveUserDto;

public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);
    RequestResponseDto<?> login(RequestLoginUserDto dto);
}
