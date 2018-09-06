package com.soccer.resource;

import com.soccer.model.Country;
import com.soccer.model.ManagerRequest;
import com.soccer.model.ManagerResponse;
import com.soccer.repository.ClubRepository;
import com.soccer.repository.CountryRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.api.SoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Country> findAllUsers() {
        return countryRepository.findAll();
    }

    @PostMapping(path="/create-manager")
    @ResponseBody
    public ManagerResponse createManager(@RequestBody ManagerRequest managerRequest) {
        return soccerServiceImpl.createManager(managerRequest);
    }
}
