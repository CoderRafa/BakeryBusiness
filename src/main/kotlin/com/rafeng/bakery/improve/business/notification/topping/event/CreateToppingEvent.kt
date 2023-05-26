package com.rafeng.bakery.improve.business.notification.topping.event

import com.rafeng.bakery.improve.business.model.Topping
import org.springframework.context.ApplicationEvent

class CreateToppingEvent(toppingEntity: Topping, val message: String) : ApplicationEvent(toppingEntity)