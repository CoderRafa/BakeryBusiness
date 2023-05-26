package com.rafeng.bakery.improve.business.notification.filling.listener

import com.rafeng.bakery.improve.business.notification.filling.event.DeleteFillingEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class DeleteFillingEmailEventListener: ApplicationListener<DeleteFillingEvent> {
    override fun onApplicationEvent(event: DeleteFillingEvent) {
        println("Handle a delete filling event with message ${event.message}")
        println("Handle an object ${event.source}")
    }
}