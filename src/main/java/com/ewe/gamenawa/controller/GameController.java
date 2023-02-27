package com.ewe.gamenawa.controller;

import com.ewe.gamenawa.dto.GameListResponse;
import com.ewe.gamenawa.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping()
    public GameListResponse getGameScoreInfo(@RequestParam String title, Pageable pageable) {
        return gameService.getGameScoreInfo(title, pageable);
    }
}
