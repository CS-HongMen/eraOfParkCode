package com.iFox.mapperDAO;

import com.iFox.entity.ParkUser;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface ParkUserMapper {

    List<ParkUser> getUserByPage(Integer id);

}
