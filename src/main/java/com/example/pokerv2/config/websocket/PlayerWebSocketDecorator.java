package com.example.pokerv2.config.websocket;

import com.example.pokerv2.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.WebSocketHandler;

@Slf4j
public class PlayerWebSocketDecorator extends WebSocketHandlerDecorator {

    private final PlayerService playerLifeCycleService;

    public PlayerWebSocketDecorator(WebSocketHandler delegate, PlayerService playerLifeCycleService) {
        super(delegate);
        this.playerLifeCycleService = playerLifeCycleService;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        super.afterConnectionClosed(session, closeStatus);
        handleDisconnect(session, closeStatus);
    }

    private void handleDisconnect(WebSocketSession session, CloseStatus closeStatus) {
        String playerId = (String) session.getAttributes().get("player_id");
        if (playerId != null) {
            playerLifeCycleService.setDisconnect(Long.parseLong(playerId));
            log.info("Player disconnected: {}, reason: {}", playerId, closeStatus);
        }
    }
}

