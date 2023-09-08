package com.WebApp.FootballTeamManager.Services;

import com.WebApp.FootballTeamManager.Model.Statistics;
import com.WebApp.FootballTeamManager.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatiscticsService {
    @Autowired
    StatisticsRepository statisticsRepository;

    public void deleteStatistics(Long id) {
        statisticsRepository.deleteStatisticsById(id);
    }

    public void deleteStatisticsByPlayerId(Long id) {
        statisticsRepository.deleteStatisticsByPlayerId(id);
    }

    public Statistics findStatisticsById(Long id) {
        return statisticsRepository.findStatisticsById(id);
    }

    public Statistics findStatisticsByPlayerId(Long id) {
        return statisticsRepository.findStatisticsByPlayerId(id);
    }

    public Statistics addStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public Statistics updateStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }


}
