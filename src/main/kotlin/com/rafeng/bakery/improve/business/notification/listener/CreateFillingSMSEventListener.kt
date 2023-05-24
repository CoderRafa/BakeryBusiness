package com.rafeng.bakery.improve.business.notification.listener

import com.rafeng.bakery.improve.business.notification.event.CreateFillingEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CreateFillingSMSEventListener : ApplicationListener<CreateFillingEvent> {
    override fun onApplicationEvent(event: CreateFillingEvent) {
        println("Handle a create filling event with message ${event.message} and send SMS")
        println("Handle an object: ${event.source} and send SMS")
    }
}