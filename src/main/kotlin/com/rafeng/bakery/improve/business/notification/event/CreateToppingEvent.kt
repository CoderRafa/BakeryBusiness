package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Topping
import com.rafeng.bakery.improve.business.model.entity.ToppingEntity
import org.springframework.context.ApplicationEvent

class CreateToppingEvent(toppingEntity: Topping, val message: String) : ApplicationEvent(toppingEntity)