package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Filling
import org.springframework.context.ApplicationEvent

class CreateFillingEvent(fillingEntity: Filling, val message: String) : ApplicationEvent(fillingEntity)