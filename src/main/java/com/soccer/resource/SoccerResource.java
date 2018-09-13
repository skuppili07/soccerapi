package com.soccer.resource;

import com.soccer.model.*;
import com.soccer.repository.ClubRepository;
import com.soccer.repository.CountryRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.api.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/soccer")
public class SoccerResource {

    @Autowired
    private SoccerService soccerServiceImpl;
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubRepository clubRepository;


    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path="/managers")
    public @ResponseBody List<Manager> findAllUsers() {
        return soccerServiceImpl.getAllManagers();
    }

    @PostMapping(path="/create-manager")
    @ResponseBody
    public ManagerResponse createManager(@RequestBody ManagerRequest managerRequest) {
        return soccerServiceImpl.createManager(managerRequest);
    }

    @GetMapping(path = "/players")
    public @ResponseBody List<Player> findAllPlayers() {
        return soccerServiceImpl.getAllPlayers();
    }
    @GetMapping(path = "/get-player/{playerId}")
    public @ResponseBody Player findPlayerById(@PathVariable String playerId) {
        return soccerServiceImpl.getPlayerById(playerId);
    }
    @PostMapping(path = "/create-player")
    @ResponseBody
    public PlayerResponse createPlayer (@RequestBody PlayerRequest playerRequest) {
        return soccerServiceImpl.createPlayer(playerRequest);
    }


}
