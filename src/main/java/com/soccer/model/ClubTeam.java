package com.soccer.model;

import javax.persistence.*;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */
@Entity
@Table(name="club_team")
public class ClubTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer team_id;

    @Column
    private String team_name;

    @Column
    private String team_country;

    @Column
    private String team_mnger_id;

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_country() {
        return team_country;
    }

    public void setTeam_country(String team_country) {
        this.team_country = team_country;
    }

    public String getTeam_mnger_id() {
        return team_mnger_id;
    }

    public void setTeam_mnger_id(String team_mnger_id) {
        this.team_mnger_id = team_mnger_id;
    }
}
