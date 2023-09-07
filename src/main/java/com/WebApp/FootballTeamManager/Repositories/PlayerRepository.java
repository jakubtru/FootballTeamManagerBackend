package com.WebApp.FootballTeamManager.Repositories;

import com.WebApp.FootballTeamManager.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    void deletePlayerById(Long id);

    Optional<Player> findPlayerById(Long id);
}
