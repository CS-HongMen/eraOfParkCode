package com.iFox.filter;

import com.google.gson.Gson;
import com.iFox.service.LoginService;
import com.iFox.utils.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");

        Gson gson = new Gson();
        TokenModel tokenModel = gson.fromJson(token, TokenModel.class);

        TokenModel tokenModelCheck = loginService.getToken(tokenModel.getEmail());
        if (tokenModelCheck == tokenModel && tokenModelCheck.equals(tokenModel)) {
            response.setContentType("text/plain; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("200");
            return true;
        } else {
            response.setContentType("text/plain; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("406");
            return false;
        }
    }
}
