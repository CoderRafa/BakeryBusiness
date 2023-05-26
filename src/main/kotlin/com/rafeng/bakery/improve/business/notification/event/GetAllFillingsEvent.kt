package com.rafeng.bakery.improve.business.notification.event

import com.rafeng.bakery.improve.business.model.Filling
import org.springframework.context.ApplicationEvent

class GetAllFillingsEvent(listOfFillingIds: List<Long>, val message: String): ApplicationEvent(listOfFillingIds)
