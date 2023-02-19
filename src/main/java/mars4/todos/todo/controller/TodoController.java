package mars4.todos.todo.controller;

import lombok.RequiredArgsConstructor;
import mars4.todos.coommon.dto.RequestResponseDto;
import mars4.todos.todo.dto.RequestTodoCheckDto;
import mars4.todos.todo.dto.RequestTodoDeleteDto;
import mars4.todos.todo.dto.RequestTodoSaveDto;
import mars4.todos.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping()
    public RequestResponseDto<?> todoSave(@RequestBody RequestTodoSaveDto dto){
        return todoService.save(dto);
    }

    @PostMapping("/check")
    public RequestResponseDto<?> todoCheck(@RequestBody RequestTodoCheckDto dto){
        return todoService.check(dto);
    }

    @PostMapping("delete")
    public RequestResponseDto<?> todoDelete(@RequestBody RequestTodoDeleteDto dto){
        return todoService.delete(dto);
    }

}
