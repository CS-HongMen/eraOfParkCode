package com.iFox.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Controller
public class LoginControl {

    @RequestMapping("login")
    public @ResponseBody String login(){

        return null;
    }
}
