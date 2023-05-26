package com.rafeng.bakery.improve.business.notification.topping.listener

import com.rafeng.bakery.improve.business.notification.topping.event.DeleteToppingEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class DeleteToppingEmailEventListener : ApplicationListener<DeleteToppingEvent> {
    override fun onApplicationEvent(event: DeleteToppingEvent) {
        println("Handle a delete topping event with a message ${event.message}")
        println("Handle an object ${event.source}")
    }
}