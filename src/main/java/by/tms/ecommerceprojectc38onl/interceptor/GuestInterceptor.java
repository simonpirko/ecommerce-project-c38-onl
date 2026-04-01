package by.tms.ecommerceprojectc38onl.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Objects;

@Component
public class GuestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws IOException {
        HttpSession session = req.getSession();
        if(Objects.isNull(session)) {
            resp.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
