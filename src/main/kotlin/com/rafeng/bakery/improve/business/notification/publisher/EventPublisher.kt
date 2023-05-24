package com.rafeng.bakery.improve.business.notification.publisher

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class EventPublisher(private val publisher: ApplicationEventPublisher) {
    private val log = LoggerFactory.getLogger(EventPublisher::class.java)

    fun publishEvent(event: ApplicationEvent) {
        log.debug("Publish a new event")
        publisher.publishEvent(event)
    }
}