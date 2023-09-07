package com.WebApp.FootballTeamManager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private int number;
    private Date dateOfBirth;
    private String imageUrl;

    public Player() {
    }

    public Player(String name, String position, int number, Date dateOfBirth, String imageUrl) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.imageUrl = imageUrl;
    }
}


