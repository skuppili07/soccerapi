package com.soccer.service.api;

import com.soccer.model.ManagerRequest;
import com.soccer.model.ManagerResponse;

/**
 * Created by karte on 9/4/2018.
 */
public interface SoccerService {
    ManagerResponse createManager(ManagerRequest managerRequest);
}
