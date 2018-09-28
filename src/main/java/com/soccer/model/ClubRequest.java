package com.soccer.model;

/**
 * Created by karte on 9/27/2018.
 */
public class ClubRequest {


    private Integer club_id;
    
    private String name;
     
    private Integer country_id;

     
    private Integer manager_id;

    public Integer getClub_id() {
        return club_id;
    }

    public void setClub_id(Integer club_id) {
        this.club_id = club_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }
}
