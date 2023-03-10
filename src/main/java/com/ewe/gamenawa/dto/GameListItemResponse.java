package com.ewe.gamenawa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameListItemResponse {
    private long id;
    private int appid;
    private String name;
    private String steamScore;
    private String metacriticScore;
}
