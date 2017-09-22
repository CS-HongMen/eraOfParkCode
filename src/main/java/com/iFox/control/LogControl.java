package com.iFox.control;

import com.google.gson.Gson;
import com.iFox.entity.ParkLog;
import com.iFox.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
@Controller
public class LogControl {

    @Autowired
    private LogService logService;

    private Gson gson = new Gson();

    @RequestMapping("getAllLog")
    public
    @ResponseBody
    String getAll(int pageNo, int PageSize) {

        List<ParkLog> parkLogList = logService.getLogByPage(pageNo, PageSize);
        return gson.toJson(parkLogList);
    }

    @RequestMapping("comUpLog")
    public
    @ResponseBody
    String comUpLog(String logParam, HttpServletRequest request) {
        ParkLog parkLog = gson.fromJson(logParam, ParkLog.class);
        List<String> imgPath = new ArrayList<>();
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multipartHttpServletRequest
                    .getFileNames();
            while (iterator.hasNext()) {
                MultipartFile multipartFile = multipartHttpServletRequest
                        .getFile(iterator.next());
                if (multipartFile != null) {
                    String name = multipartFile
                            .getOriginalFilename();
                    if (name.trim() != "") {
                        String path = request.getServletContext().getRealPath("/");
                        try {
                            String realPath = path + name;
                            multipartFile.transferTo(new File(realPath));
                            imgPath.add(realPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            String realImgPath = gson.toJson(imgPath);
            parkLog.setImgPath(realImgPath);
            logService.save(parkLog);
        }
        return "200" + gson.toJson(imgPath);
    }
}
