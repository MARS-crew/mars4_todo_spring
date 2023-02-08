package mars4.todos.common.controller;

import mars4.todos.util.SecurityUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping("/")
    public String test(){
        return "Hello Spring";
    }

    @GetMapping("/test")
    public String test2(){
        return SecurityUtil.getCurrentUserIdx();
    }
}
