package com.ewe.gamenawa.controller;

import com.ewe.gamenawa.dto.GameListScoreInfo;
import com.ewe.gamenawa.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping()
    public GameListScoreInfo getGameScoreInfo(@RequestParam String title, Pageable pageable) {
        return gameService.getGameScoreInfo(title, pageable);
    }
}
