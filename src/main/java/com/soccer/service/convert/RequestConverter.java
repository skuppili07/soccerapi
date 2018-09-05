package com.soccer.service.convert;

import com.soccer.model.Manager;
import com.soccer.model.ManagerRequest;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by karte on 9/5/2018.
 */
@Component
public class RequestConverter {

    public Manager convertManagerRequest(ManagerRequest managerRequest) {
        Manager manager = new Manager();
        if(managerRequest.getManager_frst_nm() != null && managerRequest.getManager_frst_nm().trim() != "") {
            manager.setManager_frst_nm(managerRequest.getManager_frst_nm());
        }
        if(managerRequest.getManager_lst_nm() != null && managerRequest.getManager_lst_nm().trim() != "") {
            manager.setManager_lst_nm(managerRequest.getManager_lst_nm());
        }
        if(managerRequest.getManager_dob() != null && managerRequest.getManager_dob().trim() != "") {
            manager.setManager_dob(managerRequest.getManager_dob());
        }
        if(managerRequest.getManager_origin_place() != null && managerRequest.getManager_origin_place().trim() != "") {
            manager.setManager_origin_place(managerRequest.getManager_origin_place());
        }
        if(managerRequest.getManager_cntrct_end_dt() != null && managerRequest.getManager_cntrct_end_dt().trim() != "") {
            try {
                manager.setManager_cntrct_end_dt(convertDate(managerRequest.getManager_cntrct_end_dt()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(managerRequest.getManager_cntrct_strt_dt() != null && managerRequest.getManager_cntrct_strt_dt().trim() != "") {
            try {
                manager.setManager_cntrct_strt_dt(convertDate(managerRequest.getManager_cntrct_strt_dt()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return manager;
    }

    private Date convertDate(String stringFormattedDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        date = sdf.parse(stringFormattedDate);
        return date;
    }
}
