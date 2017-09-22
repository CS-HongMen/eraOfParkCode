package com.iFox.service;

import com.iFox.entity.ParkLog;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface LogService {
    List<ParkLog> getLogByPage(int pageNo, int pageSize);

    void save(ParkLog parkLog);
}
