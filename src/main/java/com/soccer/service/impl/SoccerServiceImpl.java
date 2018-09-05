package com.soccer.service.impl;

import com.soccer.model.Manager;
import com.soccer.model.ManagerRequest;
import com.soccer.model.ManagerResponse;
import com.soccer.repository.ManagerRepository;
import com.soccer.service.api.SoccerService;
import com.soccer.service.convert.RequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karte on 9/4/2018.
 */
@Service
public class SoccerServiceImpl implements SoccerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RequestConverter requestConverter;

    @Override
    public ManagerResponse createManager(ManagerRequest managerRequest) {
        ManagerResponse managerResponse = new ManagerResponse();
        Manager manager = requestConverter.convertManagerRequest(managerRequest);
        Manager managerFromDB = managerRepository.save(manager);
        if(managerFromDB.getManager_id() != null) {
            managerResponse.setManager_id(managerFromDB.getManager_id());
        }
         return managerResponse;
    }
}
