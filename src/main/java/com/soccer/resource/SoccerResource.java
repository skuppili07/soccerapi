package com.soccer.resource;

import com.soccer.model.*;
import com.soccer.repository.ClubRepository;
import com.soccer.repository.CountryRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.api.SoccerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Logger
@RequestMapping(path="/soccer")
@Api(value = "Soccer API", description = "Rest API for soccer operations", tags = "Soccer API")
public class SoccerResource {

    @Autowired
    private SoccerService soccerServiceImpl;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubRepository clubRepository;


    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path="/~/managers", produces = "application/JSON")
    @ApiOperation(value = "Display All Managers Info", response = Manager.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public @ResponseBody List<Manager> findAllUsers() {
        return soccerServiceImpl.getAllManagers();
    }

    @PostMapping(path="/create-manager")
    @ResponseBody
    @ApiOperation(value = "Creates Manager", response = ManagerResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ManagerResponse createManager(@RequestBody ManagerRequest managerRequest) {
        return soccerServiceImpl.createManager(managerRequest);
    }

    @GetMapping(path="/get-manager/{managerId}")
    @ResponseBody
    @ApiOperation(value = "gets the manager by id", response = Manager.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public Manager findManagerById(@PathVariable String managerId) {
        return soccerServiceImpl.getManagerById(managerId);
    }
    @PatchMapping(path = "/edit-manager/{managerId}")
    @ResponseBody
    @ApiOperation(value = "Edit the manager", response = ManagerResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ResponseEntity<ManagerResponse> editManager(@RequestBody ManagerRequest managerRequest, @PathVariable String managerId) {
        ManagerResponse managerResponse = new ManagerResponse();
        try {
            managerResponse = soccerServiceImpl.editManager(managerRequest, managerId);
        }
        catch (Exception ex) {
            System.out.println("Error While invoking the patch reuqest");
        }
        return  new ResponseEntity<>(managerResponse, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/~/players")
    @ApiOperation(value = "Get All Players", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public @ResponseBody List<Player> findAllPlayers() {
        return soccerServiceImpl.getAllPlayers();
    }

    @GetMapping(path = "/get-player")
    @ApiOperation(value = "Get Player By Name", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public @ResponseBody List<Player> filterPlayer(@RequestParam String playerName) {
        return soccerServiceImpl.getPlayerByName(playerName);
    }

    @GetMapping(path = "/get-player/{playerId}")
    @ApiOperation(value = "Get Player By ID", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public @ResponseBody Player findPlayerById(@PathVariable String playerId) {
        return soccerServiceImpl.getPlayerById(playerId);
    }
    
    @PostMapping(path = "/create-player")
    @ResponseBody
    @ApiOperation(value = "Create Player", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public PlayerResponse createPlayer (@RequestBody PlayerRequest playerRequest) {
        return soccerServiceImpl.createPlayer(playerRequest);
    }

    @PatchMapping(path = "/edit-player/{playerId}")
    @ResponseBody
    @ApiOperation(value = "Edit Player", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ResponseEntity<PlayerResponse> editPlayer(@RequestBody PlayerRequest playerRequest, @PathVariable String playerId) throws Exception {
        PlayerResponse playerResponse = new PlayerResponse();
        try {
             playerResponse = soccerServiceImpl.editPlayer(playerRequest, playerId);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return  new ResponseEntity<>(playerResponse, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/~/clubs")
    @ResponseBody
    @ApiOperation(value = "Get All Clubs", response = Club.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public List<Club> findAllClubs()
    {
        return soccerServiceImpl.getAllClubs();
    }

    @GetMapping(path = "/club/{clubId}")
    @ResponseBody
    @ApiOperation(value = "Get Club By ID", response = Club.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public Club getClubById(@PathVariable String clubId) throws Exception {
        Club club = new Club();
        try {
            club = soccerServiceImpl.getClubById(clubId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return  club;
    }

    @PostMapping(path = "/create-club")
    @ResponseBody
    @ApiOperation(value = "Create Club Info", response = ClubResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ClubResponse createClub(@RequestBody ClubRequest clubRequest) {
        return soccerServiceImpl.createClub(clubRequest);
    }

    @PatchMapping(path = "/edit-club/{clubId}")
    @ResponseBody
    @ApiOperation(value = "Edit Club Info", response = ClubResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ResponseEntity<ClubResponse> editClub(@RequestBody ClubRequest clubRequest, @PathVariable String clubId) throws Exception {
        ClubResponse clubResponse = new ClubResponse();
        try {
            clubResponse = soccerServiceImpl.editClub(clubRequest, clubId);
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ResponseEntity<ClubResponse>(clubResponse, HttpStatus.NO_CONTENT);
    }

}
