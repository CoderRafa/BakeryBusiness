package com.rafeng.bakery.improve.business.notification.topping.event

import org.springframework.context.ApplicationEvent

class GetAllToppingsEvent(listOfToppingIds: List<Long>, val message: String) : ApplicationEvent(listOfToppingIds)