package com.ewe.gamenawa.service;

import com.ewe.gamenawa.dto.GameListScoreInfo;
import com.ewe.gamenawa.dto.GameScoreInfo;
import com.ewe.gamenawa.entity.Game;
import com.ewe.gamenawa.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public GameListScoreInfo getGameScoreInfo(String title, Pageable pageable) {
        Page<Game> games = gameRepository.findByNameContaining(title, pageable);
        return GameListScoreInfo.builder()
                .totalCount(games.getTotalElements())
                .gameScoreInfoList(
                    games.getContent().stream()
                            .map(gameScoreInfo -> new GameScoreInfo(
                                    gameScoreInfo.getId(),
                                    gameScoreInfo.getAppid(),
                                    gameScoreInfo.getName(),
                                    gameScoreInfo.getSteamScore(),
                                    gameScoreInfo.getMetacriticScore()))
                            .collect(Collectors.toList())
                ).build();
    }
}
