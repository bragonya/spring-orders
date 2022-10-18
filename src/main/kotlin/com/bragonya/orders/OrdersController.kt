package com.bragonya.orders

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrdersController {

    @MessageMapping("/orders")
    fun processOrder(message: String): String {
        return message.uppercase()
    }
}