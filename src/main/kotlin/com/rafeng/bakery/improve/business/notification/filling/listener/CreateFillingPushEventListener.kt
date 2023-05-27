package com.rafeng.bakery.improve.business.notification.filling.listener

import com.rafeng.bakery.improve.business.notification.filling.event.CreateFillingEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class CreateFillingPushEventListener : ApplicationListener<CreateFillingEvent> {
    override fun onApplicationEvent(event: CreateFillingEvent) {
        println("Handle a create filling event with message ${event.message}  and send Push Notification")
        println("Handle an object: ${event.source}  and send Push Notification")
    }
}