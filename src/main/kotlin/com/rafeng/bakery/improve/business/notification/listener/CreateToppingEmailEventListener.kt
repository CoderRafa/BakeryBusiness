package com.rafeng.bakery.improve.business.notification.listener

import com.rafeng.bakery.improve.business.notification.event.CreateToppingEvent
import org.springframework.context.ApplicationListener

class CreateToppingEmailEventListener : ApplicationListener<CreateToppingEvent> {
    override fun onApplicationEvent(event: CreateToppingEvent) {
        println("Handle a create topping event with a message ${event.message}")
        println("Handle an object ${event.source}")
    }
}