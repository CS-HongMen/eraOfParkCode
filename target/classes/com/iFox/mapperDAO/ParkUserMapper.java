package com.iFox.mapperDAO;

import com.iFox.entity.ParkUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface ParkUserMapper {

    List<ParkUser> getUserByPage(Integer id);

    ParkUser getUser(@Param("email") String email, @Param("password") String password);

}
