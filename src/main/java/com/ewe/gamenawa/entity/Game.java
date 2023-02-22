package com.ewe.gamenawa.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private int appid;

    @NotNull
    private String name;

    private String steamScore;

    private String metacriticScore;
}