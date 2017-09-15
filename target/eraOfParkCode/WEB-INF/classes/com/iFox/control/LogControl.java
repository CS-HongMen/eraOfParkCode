package com.iFox.control;

import com.google.gson.Gson;
import com.iFox.entity.ParkLog;
import com.iFox.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Controller
public class LogControl {

    @Autowired
    private LogService logService;

    @RequestMapping("getAllLog")
    public
    @ResponseBody
    String getAll(int pageNo,int PageSize) {
        Gson gson = new Gson();
        List<ParkLog> parkLogList = logService.getLogByPage(pageNo, PageSize);
        String parkLogJson = gson.toJson(parkLogList);
        return parkLogJson;
    }
}
