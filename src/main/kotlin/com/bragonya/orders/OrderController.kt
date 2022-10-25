package com.bragonya.orders

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.stereotype.Controller


@Controller
class OrderController {

    val channel = MutableSharedFlow<String>()
    init {
        println("bragonya")
        channel.onSubscription { println("bragonya new subscriber") }
    }

    @MessageMapping("stream")
    suspend fun streamOrders(): Flow<Response> {
        print("bragonya requesting flow")
        return channel.map { Response(it) }
    }

    data class Response(val data: String)

    @MessageMapping("post")
    suspend fun postStreamOrders(@Payload ordersStream: Flow<String>) {
        println("receiving flow")
        ordersStream.collect{
            print("bragonya message received $it")
            channel.emit(it)
        }
    }
}