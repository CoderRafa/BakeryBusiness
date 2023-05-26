package com.rafeng.bakery.improve.business.notification.filling.listener

import com.rafeng.bakery.improve.business.notification.filling.event.GetAllFillingsEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class GetAllFillingsEmailEventListener: ApplicationListener<GetAllFillingsEvent> {
    override fun onApplicationEvent(event: GetAllFillingsEvent) {
        println("Handle a get all fillings event with message ${event.message}")
        println("Handle an object ${event.source}")
    }
}