package com.soccer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by karte on 9/3/2018.
 */
@Entity
public class Country {
    @Id
    private Integer country_id; // the ISO 3166-1 numeric country codes

    @Column
    private String name; // the ISO 3166 official short names

    @Column
    private String alpha_2; // the ISO 3166-1 alpha-2 two-letter country codes

    @Column
    private String alpha_3; // the ISO 3166-1 alpha-3 three-letter country codes

    @Column
    private Date created_date;

    @Column
    private Date updated_date;

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha_2() {
        return alpha_2;
    }

    public void setAlpha_2(String alpha_2) {
        this.alpha_2 = alpha_2;
    }

    public String getAlpha_3() {
        return alpha_3;
    }

    public void setAlpha_3(String alpha_3) {
        this.alpha_3 = alpha_3;
    }
}
