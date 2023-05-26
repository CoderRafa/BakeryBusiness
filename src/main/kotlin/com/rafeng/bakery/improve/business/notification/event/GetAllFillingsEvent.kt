package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Filling
import org.springframework.context.ApplicationEvent

class GetAllFillingsEvent(listOfFillings: List<Filling>, val message: String): ApplicationEvent(listOfFillings)
