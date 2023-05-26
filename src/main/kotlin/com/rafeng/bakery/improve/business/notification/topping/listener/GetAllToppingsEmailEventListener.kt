package com.rafeng.bakery.improve.business.notification.topping.listener

import com.rafeng.bakery.improve.business.notification.topping.event.GetAllToppingsEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class GetAllToppingsEmailEventListener : ApplicationListener<GetAllToppingsEvent> {
    override fun onApplicationEvent(event: GetAllToppingsEvent) {
        println("Handle a get all toppings event with a message ${event.message}")
        println("Handle an object ${event.source}")
    }
}