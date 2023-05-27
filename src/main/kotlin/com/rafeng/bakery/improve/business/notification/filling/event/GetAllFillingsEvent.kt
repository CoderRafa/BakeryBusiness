package com.rafeng.bakery.improve.business.notification.filling.event

import org.springframework.context.ApplicationEvent

class GetAllFillingsEvent(listOfFillingIds: List<Long>, val message: String): ApplicationEvent(listOfFillingIds)
