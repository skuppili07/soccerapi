package com.soccer.service.api;

import com.soccer.model.*;

import java.util.List;

/**
 * Created by karte on 9/4/2018.
 */
public interface SoccerService {
    ManagerResponse createManager(ManagerRequest managerRequest);
    List<Manager> getAllManagers();
    PlayerResponse createPlayer(PlayerRequest playerRequest);
    List<Player> getAllPlayers();
    Player getPlayerById(String playerId);
}
