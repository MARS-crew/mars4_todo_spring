package mars4.todos.util;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
@NoArgsConstructor
public class SecurityUtil {
    public static String getCurrentUserIdx(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getName() == null){
            throw new RuntimeException("Security Context 에 인증 정보가 없습니다.");
        }else if(authentication.getName().equals("anonymousUser")){
            return null;
        }
        return authentication.getName();
    }
}
