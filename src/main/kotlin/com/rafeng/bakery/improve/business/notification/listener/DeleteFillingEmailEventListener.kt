package com.rafeng.bakery.improve.business.notification.listener

import com.rafeng.bakery.improve.business.notification.event.DeleteFillingEvent
import org.springframework.context.ApplicationListener

class DeleteFillingEmailEventListener: ApplicationListener<DeleteFillingEvent> {
    override fun onApplicationEvent(event: DeleteFillingEvent) {
        println("Handle a delete filling event with message ${event.message}")
        println("Handle an object ${event.source}")
    }
}