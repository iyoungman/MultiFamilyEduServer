package com.cosmos.multifamily.security;


import com.cosmos.multifamily.domain.entity.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *AuthFailureHandler
 *로그인 실패시 처리
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(AuthFailureHandler.class);
    private Gson gson;

    public AuthFailureHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("==============AuthFailureHandler Start!!=================");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        User user = new User("fail","fail","fail","fail");
        user.setResponse("0");

        response.getWriter().print(gson.toJson(user));
        response.getWriter().flush();
    }
}
