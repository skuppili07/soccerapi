package com.soccer.service.convert;

import com.soccer.model.*;
import org.springframework.stereotype.Component;

/**
 * Created by karte on 9/5/2018.
 */
@Component
public class RequestConverter {


    public Manager convertManagerRequest(ManagerRequest managerRequest, Manager manager) {
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

    public Player convertPlayerRequest(PlayerRequest playerRequest, Player player) {
        if (playerRequest.getFirst_name() != null && playerRequest.getFirst_name().trim() != "") {
            player.setFirst_name(playerRequest.getFirst_name());
        }
        if (playerRequest.getLast_name() != null && playerRequest.getLast_name().trim() != "") {
            player.setLast_name(playerRequest.getLast_name());
        }
        if (playerRequest.getBirth_date() != null && playerRequest.getBirth_date().trim() != "") {
            player.setBirth_date(playerRequest.getBirth_date());
        }
        if (playerRequest.getNationality_country_id() != null && playerRequest.getNationality_country_id().trim() != "") {
            player.setNationality_country_id(playerRequest.getNationality_country_id());
        }
        if (playerRequest.getFirst_name() != null && playerRequest.getFirst_name().trim() != "") {
            player.setFirst_name(playerRequest.getFirst_name());
        }
        if (playerRequest.getBirth_country_id() != null && playerRequest.getBirth_country_id() != 0) {
            player.setBirth_country_id(playerRequest.getBirth_country_id());
        }
        if (playerRequest.getClub_id() != null && playerRequest.getClub_id().trim() != "") {
            player.setClub_id(playerRequest.getClub_id());
        }
        if (playerRequest.getStart_date() != null) {
            player.setStart_date(playerRequest.getStart_date());
        }
        if (playerRequest.getEnd_date() != null) {
            player.setEnd_date(playerRequest.getEnd_date());
        }
        return player;
    }

    public Club convertClubRequest(ClubRequest clubRequest, Club club) {
        if (clubRequest.getName() != null && clubRequest.getName().trim() != "") {
            club.setName(clubRequest.getName());
        }
        if (clubRequest.getClub_id() != null) {
            club.setClub_id(clubRequest.getClub_id());
        }
        if (clubRequest.getManager_id() != null) {
            club.setManager_id(clubRequest.getManager_id());
        }
        if (clubRequest.getCountry_id() != null) {
            club.setCountry_id(clubRequest.getCountry_id());
        }
        return club;
    }
}
