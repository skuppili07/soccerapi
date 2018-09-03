package com.soccer.resource;

import com.soccer.model.Country;
import com.soccer.repository.ClubTeamRepository;
import com.soccer.repository.CountryRepository;
import com.soccer.repository.ManagerRepository;
import com.soccer.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/soccer")
public class SoccerResource {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubTeamRepository clubTeamRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Country> findAllUsers() {
        return countryRepository.findAll();
    }
}
