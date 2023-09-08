package com.WebApp.FootballTeamManager.Repositories;

import com.WebApp.FootballTeamManager.Model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    void deleteStatisticsById(Long id);

    Statistics findStatisticsById(Long id);

    void deleteStatisticsByPlayerId(Long id);

    Statistics findStatisticsByPlayerId(Long id);
}
