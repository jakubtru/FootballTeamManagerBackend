package com.WebApp.FootballTeamManager.Services;

import com.WebApp.FootballTeamManager.Exceptions.UserNotFoundException;
import com.WebApp.FootballTeamManager.Model.Player;
import com.WebApp.FootballTeamManager.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deletePlayerById(id);
    }

    public Player findPlayerById(Long id){
        return playerRepository.findPlayerById(id).orElseThrow(() -> new UserNotFoundException("Player with id " + id + " was not found"));
    }
}
