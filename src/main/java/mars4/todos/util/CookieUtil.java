package mars4.todos.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public static Cookie[] readAllCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return cookies;
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = readAllCookie(request);
        if(cookies != null) {
            for(Cookie c : cookies) {
                if(c.getName().equals(cookieName) ) {
                    return c.getValue();
                }
            }
        }
        return null;
    }
}
