package com.bragonya.orders.sockets.handlers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class OrdersSocketHandler @Autowired constructor(): TextWebSocketHandler() {

    private val sessions = mutableListOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("new connection")
        sessions.add(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("new message $message")
        for(s in sessions) {
            runCatching { s.sendMessage(message) }.onFailure { e -> print(" error sending message $e") }
        }
    }
}