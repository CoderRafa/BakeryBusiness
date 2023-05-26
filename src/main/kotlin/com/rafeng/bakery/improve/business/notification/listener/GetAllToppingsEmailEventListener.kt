package com.rafeng.bakery.improve.business.notification.listener

import com.rafeng.bakery.improve.business.notification.event.GetAllToppingsEvent
import org.springframework.context.ApplicationListener

class GetAllToppingsEmailEventListener : ApplicationListener<GetAllToppingsEvent> {
    override fun onApplicationEvent(event: GetAllToppingsEvent) {
        println("Handle a get all toppings event with a message ${event.message}")
        println("Handle an object ${event.source}")
    }
}