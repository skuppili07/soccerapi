package com.soccer.model;

/**
 * Created by karte on 9/5/2018.
 */
public class ManagerRequest {

    private Integer manager_id;

    private String manager_frst_nm;

    private String manager_lst_nm;

    private String manager_dob;

    private String manager_origin_place;

    private String manager_cntrct_strt_dt;

    private String manager_cntrct_end_dt;

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_frst_nm() {
        return manager_frst_nm;
    }

    public void setManager_frst_nm(String manager_frst_nm) {
        this.manager_frst_nm = manager_frst_nm;
    }

    public String getManager_lst_nm() {
        return manager_lst_nm;
    }

    public void setManager_lst_nm(String manager_lst_nm) {
        this.manager_lst_nm = manager_lst_nm;
    }

    public String getManager_dob() {
        return manager_dob;
    }

    public void setManager_dob(String manager_dob) {
        this.manager_dob = manager_dob;
    }

    public String getManager_origin_place() {
        return manager_origin_place;
    }

    public void setManager_origin_place(String manager_origin_place) {
        this.manager_origin_place = manager_origin_place;
    }

    public String getManager_cntrct_strt_dt() {
        return manager_cntrct_strt_dt;
    }

    public void setManager_cntrct_strt_dt(String manager_cntrct_strt_dt) {
        this.manager_cntrct_strt_dt = manager_cntrct_strt_dt;
    }

    public String getManager_cntrct_end_dt() {
        return manager_cntrct_end_dt;
    }

    public void setManager_cntrct_end_dt(String manager_cntrct_end_dt) {
        this.manager_cntrct_end_dt = manager_cntrct_end_dt;
    }
}
