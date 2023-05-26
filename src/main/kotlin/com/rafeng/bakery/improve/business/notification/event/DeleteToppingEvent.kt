package com.rafeng.bakery.improve.business.notification.event

import org.springframework.context.ApplicationEvent

class DeleteToppingEvent(id: Long, val message: String) : ApplicationEvent(id)