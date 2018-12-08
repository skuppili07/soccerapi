package com.soccer.service.api;

import com.soccer.model.*;

import java.util.List;

/**
 * Created by karte on 9/4/2018.
 */
public interface SoccerService {
    ManagerResponse createManager(ManagerRequest managerRequest);
    List<Manager> getAllManagers();
    Manager getManagerById(String managerId);
    PlayerResponse createPlayer(PlayerRequest playerRequest);
    PlayerResponse editPlayer(PlayerRequest playerRequest, String playerId) throws Exception;
    ManagerResponse editManager(ManagerRequest managerRequest, String managerId) throws Exception;
    List<Player> getAllPlayers();
    Player getPlayerById(String playerId);
    List<Club> getAllClubs();
    List<Player> getPlayerByName(String playerName);
    Club getClubById(String clubId) throws Exception;
    ClubResponse createClub(ClubRequest clubRequest);
    ClubResponse editClub(ClubRequest clubRequest, String clubId) throws Exception;
}
