package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Topping
import org.springframework.context.ApplicationEvent

class GetAllToppingsEvent(listOfToppings: List<Topping>, val message: String) : ApplicationEvent(listOfToppings)