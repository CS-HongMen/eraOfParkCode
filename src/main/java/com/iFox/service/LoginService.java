package com.iFox.service;

import com.iFox.entity.ParkUser;
import com.iFox.utils.TokenModel;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface LoginService {
    ParkUser getUser(String email,String password);

    void save(TokenModel tokenModel);

    void delete(String email);

    TokenModel getToken(String email);
}
