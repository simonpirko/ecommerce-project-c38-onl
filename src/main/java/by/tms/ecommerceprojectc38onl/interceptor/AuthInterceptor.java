package by.tms.ecommerceprojectc38onl.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Objects;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws IOException {
        HttpSession session = req.getSession();
        if(Objects.nonNull(session.getAttribute("currentUser"))) {
            resp.sendRedirect("/");
            return false;
        }
        return true;
    }
}
