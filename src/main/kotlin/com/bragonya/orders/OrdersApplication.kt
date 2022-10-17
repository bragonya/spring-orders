package com.bragonya.orders

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrdersApplication

fun main(args: Array<String>) {
	println("init app")
	runApplication<OrdersApplication>(*args)
}
