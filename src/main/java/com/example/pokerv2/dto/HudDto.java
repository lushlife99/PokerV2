package com.example.pokerv2.dto;

import com.example.pokerv2.model.Hud;
import com.example.pokerv2.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class HudDto {


    private Long id;

    private Long userId;
    private int totalHands;
    private int vpip;
    private int pfr;
    private int cBet;
    private int threeBet;
    private int wtsd;
    private int wsd;

    public HudDto(Hud hud) {
        this.id = hud.getId();
        this.userId = hud.getUser().getId();
        this.totalHands = hud.getTotalHands();
        this.vpip = hud.getVpip();
        this.pfr = hud.getPfr();
        this.cBet = hud.getCBet();
        this.threeBet = hud.getThreeBet();
        this.wtsd = hud.getWtsd();
        this.wsd = hud.getWsd();
    }
}
