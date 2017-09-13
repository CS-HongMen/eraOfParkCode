package com.iFox.mapperDAO;

import com.iFox.entity.ParkLog;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface ParkLogMapper {

    void saveLog(ParkLog parkLog);

    ParkLog getParkLogAndUser();
}
