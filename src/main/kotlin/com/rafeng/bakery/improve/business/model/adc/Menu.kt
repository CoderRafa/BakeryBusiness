package com.rafeng.bakery.improve.business.model.adc

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.service.PriceCalculationService
import com.rafeng.bakery.improve.business.service.PriceService

data class Menu(val menuItems: MutableSet<Item>)