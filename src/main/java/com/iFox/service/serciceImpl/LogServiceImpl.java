package com.iFox.service.serciceImpl;

import com.iFox.entity.ParkLog;
import com.iFox.mapperDAO.ParkLogMapper;
import com.iFox.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private ParkLogMapper parkLogMapper;

    @Override
    public List<ParkLog> getLogByPage(int pageNo, int pageSize) {
        List<ParkLog> logList = parkLogMapper.getLogByPage(pageNo, pageSize);

        return logList;
    }

    @Override
    public void save(ParkLog parkLog) {
        parkLogMapper.saveLog(parkLog);
    }
}
