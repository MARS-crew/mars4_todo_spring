package mars4.todos.todo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mars4.todos.common.dto.RequestResponseDto;
import mars4.todos.todo.dto.RequestSaveTodoDto;
import mars4.todos.todo.dto.RequestUpdateStateTodoDto;
import mars4.todos.todo.dto.RequestUpdateTodoDto;
import mars4.todos.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

@Tag(name="Todo List", description = "투두 리스트")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    @Operation(summary = "Save Todo", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping()
    public RequestResponseDto<?> saveTodo(@RequestBody RequestSaveTodoDto dto) {
        return todoService.saveTodo(dto);
    }

    @Operation(summary = "Find ALL Bucket", description = "모든 버킷 조회하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/")
    public RequestResponseDto<?> findAllBucket() {
        return todoService.findAll();
    }

    @Operation(summary = "Save Bucket", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/{id}")
    public RequestResponseDto<?> findBukcetById(@PathVariable(name = "id") Long id) {
        return todoService.findOne(id);
    }

    @Operation(summary = "Update Bucket", description = "버킷 수정하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/{id}")
    public RequestResponseDto<?> updateBucket(@RequestBody RequestUpdateTodoDto dto, @PathVariable(name = "id") Long id) {
        return todoService.updateTodo(dto, id);
    }

    @Operation(summary = "Update Bucket State", description = "버킷 상태 수정하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PatchMapping("/{id}")
    public RequestResponseDto<?> updateStateBucket(@RequestBody RequestUpdateStateTodoDto dto, @PathVariable(name = "id") Long id) {
        return todoService.updateStateTodo(dto, id);
    }

    @Operation(summary = "Save Bucket", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/{id}")
    public RequestResponseDto<?> deleteBucket(@PathVariable(name = "id") Long id) {
        return todoService.deleteTodo(id);
    }
}
