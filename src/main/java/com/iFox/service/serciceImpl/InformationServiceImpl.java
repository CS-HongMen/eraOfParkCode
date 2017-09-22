package com.iFox.service.serciceImpl;

import com.iFox.charRoom.vo.Information;
import com.iFox.mapperDAO.InformationMapper;
import com.iFox.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by exphuhong on 17-9-18.
 * Start
 */
@Transactional
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    @Transactional
    public void save(Information information) {
        informationMapper.save(information);
    }
}
