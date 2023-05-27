package com.rafeng.bakery.improve.business.notification.topping.listener

import com.rafeng.bakery.improve.business.notification.topping.event.CreateToppingEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CreateToppingEmailEventListener : ApplicationListener<CreateToppingEvent> {
    override fun onApplicationEvent(event: CreateToppingEvent) {
        println("Handle a create topping event with a message ${event.message}")
        println("Handle an object ${event.source}")
    }
}