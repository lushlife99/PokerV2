package com.example.pokerv2.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageType {

    PLAYER_JOIN("PLAYER_JOIN"),
    GAME_START("GAME_START"),
    ERROR("ERROR"),
    NEXT_PHASE_START("NEXT_PHASE_START"),
    GAME_END("GAME_END"),
    NEXT_ACTION("NEXT_ACTION"),
    SHOW_DOWN("SHOW_DOWN"),
    PLAYER_EXIT("PLAYER_EXIT"),

    ;

    private final String detail;
}
