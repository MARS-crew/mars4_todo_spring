package mars4.todos.todo.service;

import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.todo.domain.Todo;
import mars4.todos.todo.dto.RequestTodoCheckDto;
import mars4.todos.todo.dto.RequestTodoDeleteDto;
import mars4.todos.todo.dto.RequestTodoSaveDto;

import java.util.List;

public interface TodoService {
    RequestResponseDto<?> save(RequestTodoSaveDto dto);

    RequestResponseDto<?> check(RequestTodoCheckDto dto);

    RequestResponseDto<?> delete(RequestTodoDeleteDto dto);

}
