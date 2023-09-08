package com.WebApp.FootballTeamManager.Controllers;

import com.WebApp.FootballTeamManager.Model.Player;
import com.WebApp.FootballTeamManager.Model.Statistics;
import com.WebApp.FootballTeamManager.Services.PlayerService;
import com.WebApp.FootballTeamManager.Services.StatiscticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    PlayerService playerService;
    StatiscticsService statisticsService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Autowired
    public void setStatisticsService(StatiscticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
        Player player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/statistics/{id}")
    public ResponseEntity<?> getPlayerStatistics(@PathVariable("id") Long id) {
        return new ResponseEntity<>(statisticsService.findStatisticsByPlayerId(id), HttpStatus.OK);
    }

    @DeleteMapping("/statistics/delete/{id}")
    public ResponseEntity<?> deletePlayerStatistics(@PathVariable("id") Long id) {
        statisticsService.deleteStatisticsByPlayerId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/statistics/add/{id}")
    public ResponseEntity<?> addPlayerStatistics(@PathVariable("id") Long id, @RequestBody Statistics statistics) {
        statistics.setPlayerId(id);
        return new ResponseEntity<>(statisticsService.addStatistics(statistics), HttpStatus.CREATED);
    }

    @PutMapping("/statistics/update/{id}")
    public ResponseEntity<?> updatePlayerStatistics(@PathVariable("id") Long id, @RequestBody Statistics statistics) {
        statistics.setPlayerId(id);
        return new ResponseEntity<>(statisticsService.updateStatistics(statistics), HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("deleteAllInfo/{id}")
    public ResponseEntity<?> deleteAllInfo(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        statisticsService.deleteStatisticsByPlayerId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
