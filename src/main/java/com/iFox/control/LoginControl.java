package com.iFox.control;

import com.google.gson.Gson;
import com.iFox.entity.ParkUser;
import com.iFox.service.LoginService;
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
    private static final long EXP_DATE = 60 * 60 * 24 * 30;

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public
    @ResponseBody
    String login(String email, String password) {
        Gson gson = new Gson();
        ParkUser parkUser = loginService.getUser(email, password);
        if (parkUser != null) {
            TokenModel tokenModel = loginService.getToken(email);
            if (tokenModel != null) {
                tokenModelList.forEach(tokenModel1 -> {
                    if (tokenModel.getEmail().equals(email)) {
                        tokenModel.setTime(EXP_DATE);
                    }
                });
                return gson.toJson(tokenModel) + "&" + gson.toJson(parkUser);
            } else {
                LocalDateTime localDateTime = LocalDateTime.now();
                TokenModel newTokenModel = new TokenModel(localDateTime.toString(), email, String.valueOf(UUID.randomUUID()), EXP_DATE);
                loginService.save(newTokenModel);

                tokenModelList.add(newTokenModel);
                return gson.toJson(newTokenModel) + "&" + gson.toJson(parkUser);
            }

        }
        return "316";
    }
}
