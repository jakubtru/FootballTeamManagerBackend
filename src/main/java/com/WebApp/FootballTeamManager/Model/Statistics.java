package com.WebApp.FootballTeamManager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long playerId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int minutesPlayed;
    private int gamesPlayed;

}
