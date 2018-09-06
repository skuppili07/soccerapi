package com.soccer.service.convert;

import com.soccer.model.Manager;
import com.soccer.model.ManagerRequest;
import org.springframework.stereotype.Component;

/**
 * Created by karte on 9/5/2018.
 */
@Component
public class RequestConverter {

    public Manager convertManagerRequest(ManagerRequest managerRequest) {
        Manager manager = new Manager();
        if (managerRequest.getFirst_name() != null && managerRequest.getFirst_name().trim() != "") {
            manager.setFirst_name(managerRequest.getFirst_name());
        }
        if (managerRequest.getLast_name() != null && managerRequest.getLast_name().trim() != "") {
            manager.setLast_name(managerRequest.getLast_name());
        }
        if (managerRequest.getBirth_date() != null) {
            manager.setBirth_date(managerRequest.getBirth_date());
        }
        if (managerRequest.getCountry_id() != null) {
            manager.setCountry_id(managerRequest.getCountry_id());
        }
        if (managerRequest.getEnd_date() != null) {
            try {
                manager.setEnd_date(managerRequest.getEnd_date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (managerRequest.getStart_date() != null) {
            try {
                manager.setStart_date(managerRequest.getStart_date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return manager;
    }
}
