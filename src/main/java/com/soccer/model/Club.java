package com.soccer.model;

import javax.persistence.*;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer club_id;

    @Column
    private String name;

    @Column
    private Integer country_id;

    @Column
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
