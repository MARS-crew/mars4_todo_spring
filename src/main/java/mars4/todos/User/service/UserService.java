package mars4.todos.User.service;

import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.User.dto.RequestLoginUserDto;
import mars4.todos.User.dto.RequestSaveUserDto;

public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);
    RequestResponseDto<?> login(RequestLoginUserDto dto);
}
