package com.bragonya.orders.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.rsocket.RSocketRequester
import java.net.URI

@Configuration
class RsocketConfiguration {

    @Bean
    fun rSocketRequester(rsocketRequesterBuilder: RSocketRequester.Builder): RSocketRequester {
        return rsocketRequesterBuilder
            .websocket(
                URI.create("ws://localhost:8080/rsocket")
            )
    }

}