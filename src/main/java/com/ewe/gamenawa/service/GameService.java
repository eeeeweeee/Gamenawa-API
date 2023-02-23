package com.ewe.gamenawa.service;

import com.ewe.gamenawa.dto.GameListResponse;
import com.ewe.gamenawa.dto.GameListItemResponse;
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

    public GameListResponse getGameScoreInfo(String title, Pageable pageable) {
        Page<Game> games = gameRepository.findByNameContaining(title, pageable);
        return GameListResponse.builder()
                .totalCount(games.getTotalElements())
                .gameListItemResponses(
                    games.getContent().stream()
                            .map(gameScoreInfo -> new GameListItemResponse(
                                    gameScoreInfo.getId(),
                                    gameScoreInfo.getAppid(),
                                    gameScoreInfo.getName(),
                                    gameScoreInfo.getSteamScore(),
                                    gameScoreInfo.getMetacriticScore()))
                            .collect(Collectors.toList())
                ).build();
    }
}
