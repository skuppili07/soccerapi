package com.soccer.service.impl;

import com.soccer.model.*;
import com.soccer.repository.ManagerRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.api.SoccerService;
import com.soccer.service.convert.RequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by karte on 9/4/2018.
 */
@Service
public class SoccerServiceImpl implements SoccerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RequestConverter requestConverter;

    @Override
    public ManagerResponse createManager(ManagerRequest managerRequest) {
        ManagerResponse managerResponse = new ManagerResponse();
        Manager manager = requestConverter.convertManagerRequest(managerRequest);
        Manager managerFromDB = managerRepository.save(manager);
        if(managerFromDB.getManager_id() != null) {
            managerResponse.setManager_id(managerFromDB.getManager_id());
        }
         return managerResponse;
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> managerList = new ArrayList<>();
        managerList = managerRepository.findAll();
        return managerList;
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        PlayerResponse playerResponse = new PlayerResponse();
        Player player = requestConverter.convertPlayerRequest(playerRequest);
        Player playerFromDb = playerRepository.save(player);
        if(playerFromDb.getPlayer_Id() != null) {
            playerResponse.setPlayer_Id(playerFromDb.getPlayer_Id());
        }
        return playerResponse;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        playerList = playerRepository.findAll();
        return playerList;
    }

    @Override
    public Player getPlayerById(String playerId) {
        Player player = new Player();
        int convertedPlayerId = 0;
        try {
            convertedPlayerId = Integer.parseInt(playerId);
        }
        catch (Exception e) {

        }
        Optional<Player> playerOptional = playerRepository.findById(convertedPlayerId);
        if(playerOptional.isPresent()) {
            player = playerOptional.get();
            if(formatDate(player.getStart_date().toString()) != null) {
                player.setStart_date(formatDate(player.getStart_date().toString()));
            }
            if(formatDate(player.getEnd_date().toString()) != null) {
                player.setEnd_date(formatDate(player.getEnd_date().toString()));
            }
        }
        return player;
    }

    private LocalDate formatDate(String date) {
        LocalDate formattedDate = null;
        try {
//            formattedDate = new SimpleDateFormat("mm-dd-yyyy").parse(date.toString().split(" ")[0]);
            formattedDate =  LocalDate.parse(date.split(" ")[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}
