package com.iFox.control;

import com.google.gson.Gson;
import com.iFox.service.LoginService;
import com.iFox.utils.TokenCheck;
import com.iFox.utils.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Controller
public class LoginControl {


    public static List<TokenModel> tokenModelList = new ArrayList<>();

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public @ResponseBody String login(String email,String password){

        if (loginService.getUser(email,password) != null) {
            LocalDateTime localDateTime = LocalDateTime.now();
            TokenModel tokenModel = new TokenModel(localDateTime.toString(),email, String.valueOf(UUID.randomUUID()), 3);
            loginService.save(tokenModel);

            tokenModelList.add(tokenModel);
            Gson gson = new Gson();
            return gson.toJson(tokenModel);
        }
        return "316";
    }
}
