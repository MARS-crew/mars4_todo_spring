package mars4.todos.todo.service;

import lombok.RequiredArgsConstructor;
import mars4.todos.common.dto.RequestResponseDto;
import mars4.todos.todo.domain.Todo;
import mars4.todos.todo.dto.RequestSaveTodoDto;
import mars4.todos.todo.dto.RequestUpdateStateTodoDto;
import mars4.todos.todo.dto.RequestUpdateTodoDto;
import mars4.todos.todo.repository.TodoJpaRepository;
import mars4.todos.user.domain.User;
import mars4.todos.user.repository.UserJpaRepository;
import mars4.todos.user.service.UserServiceImpl;
import mars4.todos.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoJpaRepository todoJpaRepository;
    private final UserJpaRepository userJpaRepository;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RequestResponseDto<?> saveTodo(RequestSaveTodoDto dto) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if (findUser.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            Todo saveTodo = Todo.builder()
                    .text(dto.getText())
                    .comYn(false)
                    .user(findUser.get())
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 생성하였습니다.", todoJpaRepository.save(saveTodo));
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findAll() {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(SecurityUtil.getCurrentUserIdx());

            if (findUser.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "User를 찾을 수 없습니다.", null);
            }

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 전체 조회하였습니다.", todoJpaRepository.findAllByUser(findUser.get()));
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findOne(Long id) {
        try {
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 조회하였습니다.", todoJpaRepository.findById(id));
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> deleteTodo(Long id) {
        try {
            todoJpaRepository.deleteById(id);
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 삭제하였습니다.", true);
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> updateTodo(RequestUpdateTodoDto dto, Long id) {
        try {
            Optional<Todo> findTodo = todoJpaRepository.findById(id);

            if (findTodo.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "버킷을 찾을 수 없습니다.", null);
            }

            findTodo.get().setText(dto.getText());
            todoJpaRepository.save(findTodo.get());
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 수정하였습니다.", true);
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> updateStateTodo(RequestUpdateStateTodoDto dto, Long id) {
        try {
            Optional<Todo> findTodo = todoJpaRepository.findById(id);

            if (findTodo.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.NOT_FOUND, RequestResponseDto.Code.FAILED, "버킷을 찾을 수 없습니다.", null);
            }

            findTodo.get().setComYn(dto.isState());
            todoJpaRepository.save(findTodo.get());
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "버킷을 수정하였습니다.", true);
        } catch (Exception e) {
            logger.info("ERROR : " + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }

    }

}
