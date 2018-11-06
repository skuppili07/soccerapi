package com.soccer.service.impl;

import com.soccer.model.*;
import com.soccer.repository.ClubRepository;
import com.soccer.repository.ManagerRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.api.SoccerService;
import com.soccer.service.convert.RequestConverter;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    private ClubRepository clubRepository;

    @Autowired
    private RequestConverter requestConverter;

    @Override
    public ManagerResponse createManager(ManagerRequest managerRequest) {
        ManagerResponse managerResponse = new ManagerResponse();
        Manager managerSentForReq = new Manager();
        Manager manager = requestConverter.convertManagerRequest(managerRequest, managerSentForReq);
        manager.setCreated_date(new Date());
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
    public Manager getManagerById(String managerId) {
        Manager manager = new Manager();
        int convertedManagerId = 0;
        try {
            convertedManagerId = Integer.parseInt(managerId);
        }
        catch (Exception e) {

        }
        Optional<Manager> managerOptional = managerRepository.findById(convertedManagerId);
        if(managerOptional.isPresent()) {
            manager = managerOptional.get();
            if(formatDate(manager.getStart_date().toString()) != null) {
                manager.setStart_date(formatDate(manager.getStart_date().toString()));
            }
            if(formatDate(manager.getEnd_date().toString()) != null) {
                manager.setEnd_date(formatDate(manager.getEnd_date().toString()));
            }
        }
        return manager;
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        PlayerResponse playerResponse = new PlayerResponse();
        Player playerSentForReq = new Player();
        Player player = requestConverter.convertPlayerRequest(playerRequest, playerSentForReq);
        player.setCreated_date(new Date());
        Player playerFromDb = playerRepository.save(player);
        if(playerFromDb.getPlayer_Id() != null) {
            playerResponse.setPlayer_Id(playerFromDb.getPlayer_Id());
        }
        return playerResponse;
    }

    @Override
    public PlayerResponse editPlayer(PlayerRequest playerRequest, String playerId) throws Exception {
        PlayerResponse playerResponse = new PlayerResponse();
        Player player = getPlayerById(playerId);
        if(player == null) {
            throw new Exception("Player not found with this id");
        }
        if(player != null && playerRequest != null){
            player = getModifiedPlayerRequest(player, playerRequest);
        }
//        Player player = requestConverter.convertPlayerRequest(playerRequest);
        player.setUpdated_date(new Date());
        Player playerResponseFromDB = playerRepository.save(player);
        if(playerResponseFromDB.getPlayer_Id() != null) {
            playerResponse.setPlayer_Id(playerResponseFromDB.getPlayer_Id());
        }
        return playerResponse;
    }

    @Override
    public ClubResponse editClub(ClubRequest clubRequest, String clubId) throws Exception {
        ClubResponse clubResponse = new ClubResponse();
        try {
            Club club = getClubById(clubId);
            if (club == null) {
                throw new Exception("Club is not Available");
            }
            else {
                club = getModifiedClubRequest(club, clubRequest);
                club.setUpdated_date(new Date());
            }
                Club cludReponseFromDb = clubRepository.save(club);
            if(cludReponseFromDb.getClub_id() != null) {
                clubResponse.setClub_id(cludReponseFromDb.getClub_id());
            }
        } catch (Exception e) {
            throw new Exception("error while updating the club info");
        }

        return clubResponse;
    }

    @Override
    public ManagerResponse editManager(ManagerRequest managerRequest, String managerId) throws Exception {
        ManagerResponse managerResponse = new ManagerResponse();
        Manager manager = getManagerById(managerId);
        if(manager == null) {
            throw new NotFoundException("Manager not found with this id");
        }
        if(manager != null && managerRequest != null){
            manager = getModifiedManagerRequest(manager, managerRequest);
        }
        manager.setUpdated_date(new Date());
        Manager managerResponseFromDB = managerRepository.save(manager);
        if(managerResponseFromDB.getManager_id() != null) {
            managerResponse.setManager_id(managerResponseFromDB.getManager_id());
        }
        return managerResponse;
    }

    private Manager getModifiedManagerRequest(Manager manager, ManagerRequest managerRequest) {
        return requestConverter.convertManagerRequest(managerRequest, manager);
    }

    private Club getModifiedClubRequest(Club club, ClubRequest clubRequest) {
        return requestConverter.convertClubRequest(clubRequest, club);
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

    @Override
    public List<Club> getAllClubs() {
        List<Club> clubList = new ArrayList<>();
        clubList = clubRepository.findAll();
        return clubList;
    }

    @Override
    public Club getClubById(String clubId) throws Exception {
        Club club = new Club();
        int convertedClubId = 0;
        try {
            convertedClubId = Integer.parseInt(clubId);
        }
        catch (Exception e) {

        }
        Optional<Club> clubOptional = clubRepository.findById(convertedClubId);
        if(clubOptional.isPresent()) {
            club = clubOptional.get();
        }
        else {
            throw new Exception("Cannot find the club with this id = " + clubId);
        }
        return club;
    }

    @Override
    public ClubResponse createClub(ClubRequest clubRequest) {
        ClubResponse clubResponse = new ClubResponse();
        Club clubSentForReq = new Club();
        Club club = requestConverter.convertClubRequest(clubRequest, clubSentForReq);
        club.setCreated_date(new Date());
        Club clubFromDB = clubRepository.save(club);
        if(clubFromDB.getClub_id() != null) {
            clubResponse.setClub_id(clubFromDB.getClub_id());
        }
        return clubResponse;
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

    private Player getModifiedPlayerRequest(Player player, PlayerRequest playerRequest) {
            return requestConverter.convertPlayerRequest(playerRequest, player);
    }
}
