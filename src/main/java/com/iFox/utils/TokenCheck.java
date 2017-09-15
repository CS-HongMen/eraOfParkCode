package com.iFox.utils;

import com.iFox.control.LoginControl;
import com.iFox.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by exphuhong on 17-9-10.
 * Start
 */
@Component
public class TokenCheck{
    private static boolean flag = true;


    @Autowired
    private LoginService loginService ;

    public void execute() {

        new Worker().start();
    }


    private  class Worker extends Thread {

        @Override
        public void run() {

            try {
                while (flag) {
                    Thread.sleep(1000);
                    List<TokenModel> list = LoginControl.tokenModelList;
                    list.forEach(tokenModel -> tokenModel.setTime(tokenModel.getTime() - 1));
                    for (int i = 0;i<list.size();i++) {
                        if (list.get(i).getTime() == 0) {
                            TokenCheck.this.loginService.delete(list.get(i).getEmail());
                            list.remove(list.get(i));
                            i -= 1;
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
