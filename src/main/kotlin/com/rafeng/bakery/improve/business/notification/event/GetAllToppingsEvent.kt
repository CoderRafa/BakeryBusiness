package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Topping
import org.springframework.context.ApplicationEvent

class GetAllToppingsEvent(listOfToppingIds: List<Long>, val message: String) : ApplicationEvent(listOfToppingIds)