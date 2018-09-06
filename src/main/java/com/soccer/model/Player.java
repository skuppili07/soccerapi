package com.soccer.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer player_Id;

    @Column
    private String first_name;

    @Column
    private String middle_name;

    @Column
    private String last_name;

    @Column
    private String birth_date;

    @Column
    private String nationality_country_id;

    @Column
    private Integer birth_country_id;

    @Column
    private String club_id;

    @Column
    private Date start_date;

    @Column
    private Date end_date;

    public Integer getPlayer_Id() {
        return player_Id;
    }

    public void setPlayer_Id(Integer player_Id) {
        this.player_Id = player_Id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getNationality_country_id() {
        return nationality_country_id;
    }

    public void setNationality_country_id(String nationality_country_id) {
        this.nationality_country_id = nationality_country_id;
    }

    public Integer getBirth_country_id() {
        return birth_country_id;
    }

    public void setBirth_country_id(Integer birth_country_id) {
        this.birth_country_id = birth_country_id;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
