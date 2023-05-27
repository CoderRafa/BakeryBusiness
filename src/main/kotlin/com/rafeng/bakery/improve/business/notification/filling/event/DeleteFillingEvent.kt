package com.rafeng.bakery.improve.business.notification.filling.event

import org.springframework.context.ApplicationEvent

class DeleteFillingEvent(id: Long, val message: String): ApplicationEvent(id)