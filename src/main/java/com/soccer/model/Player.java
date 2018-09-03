package com.soccer.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer player_Id;

    @Column
    private String player_frst_nm;

    @Column
    private String player_lst_nm;

    @Column
    private String player_dob;

    @Column
    private String player_intern_team;

    @Column
    private String player_origin_cntry;

    @Column
    private Integer club_team_id;

    @Column
    private String player_middle_nm;

    @Column
    private Date player_cntrct_start_date;

    @Column
    private Date player_cntrct_end_date;

    public String getPlayer_middle_nm() {
        return player_middle_nm;
    }

    public void setPlayer_middle_nm(String player_middle_nm) {
        this.player_middle_nm = player_middle_nm;
    }

    public Integer getPlayer_Id() {
        return player_Id;
    }

    public void setPlayer_Id(Integer player_Id) {
        this.player_Id = player_Id;
    }

    public String getPlayer_frst_nm() {
        return player_frst_nm;
    }

    public void setPlayer_frst_nm(String player_frst_nm) {
        this.player_frst_nm = player_frst_nm;
    }

    public String getPlayer_lst_nm() {
        return player_lst_nm;
    }

    public void setPlayer_lst_nm(String player_lst_nm) {
        this.player_lst_nm = player_lst_nm;
    }

    public String getPlayer_dob() {
        return player_dob;
    }

    public void setPlayer_dob(String player_dob) {
        this.player_dob = player_dob;
    }

    public String getPlayer_intern_team() {
        return player_intern_team;
    }

    public void setPlayer_intern_team(String player_intern_team) {
        this.player_intern_team = player_intern_team;
    }

    public String getPlayer_origin_cntry() {
        return player_origin_cntry;
    }

    public void setPlayer_origin_cntry(String player_origin_cntry) {
        this.player_origin_cntry = player_origin_cntry;
    }

    public Integer getClub_team_id() {
        return club_team_id;
    }

    public void setClub_team_id(Integer club_team_id) {
        this.club_team_id = club_team_id;
    }

    public Date getPlayer_cntrct_start_date() {
        return player_cntrct_start_date;
    }

    public void setPlayer_cntrct_start_date(Date player_cntrct_start_date) {
        this.player_cntrct_start_date = player_cntrct_start_date;
    }

    public Date getPlayer_cntrct_end_date() {
        return player_cntrct_end_date;
    }

    public void setPlayer_cntrct_end_date(Date player_cntrct_end_date) {
        this.player_cntrct_end_date = player_cntrct_end_date;
    }
}
