package com.iFox.service.serciceImpl;

import com.iFox.entity.ParkUser;
import com.iFox.mapperDAO.ParkUserMapper;
import com.iFox.mapperDAO.TokenMapper;
import com.iFox.service.LoginService;
import com.iFox.utils.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ParkUserMapper parkUserMapper;

    @Autowired
    private TokenMapper tokenMapper;
    @Override
    @Transactional
    public void save(TokenModel tokenModel) {
        tokenMapper.save(tokenModel);
    }

    @Override
    public ParkUser getUser(String email,String password) {
        return parkUserMapper.getUser(email,password);
    }

    @Override
    @Transactional
    public void delete(String email) {
        tokenMapper.delete(email);
    }

    @Override
    public TokenModel getToken(String email) {
        return tokenMapper.getToken(email);
    }
}
