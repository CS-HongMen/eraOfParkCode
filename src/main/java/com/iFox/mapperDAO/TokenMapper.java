package com.iFox.mapperDAO;

import com.iFox.utils.TokenModel;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface TokenMapper {

    void save(TokenModel tokenModel);

    void delete(String email);

    TokenModel getToken(String email);
}
