package mars4.todos.todo.service;

import mars4.todos.common.dto.RequestResponseDto;
import mars4.todos.todo.dto.RequestSaveTodoDto;
import mars4.todos.todo.dto.RequestUpdateStateTodoDto;
import mars4.todos.todo.dto.RequestUpdateTodoDto;

public interface TodoService {
    RequestResponseDto<?> saveTodo(RequestSaveTodoDto dto);
    RequestResponseDto<?> findAll();
    RequestResponseDto<?> findOne(Long id);
    RequestResponseDto<?> deleteTodo(Long id);
    RequestResponseDto<?> updateTodo(RequestUpdateTodoDto dto, Long id);
    RequestResponseDto<?> updateStateTodo(RequestUpdateStateTodoDto dto, Long id);
}
