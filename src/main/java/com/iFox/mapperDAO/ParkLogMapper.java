package com.iFox.mapperDAO;

import com.iFox.entity.ParkLog;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface ParkLogMapper {

    void saveLog(ParkLog parkLog);

    List<ParkLog> getLogByPage(int pageNo, int pageSize);
}
