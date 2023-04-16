package com.rafeng.bakery.improve.business.model.controller

import com.rafeng.bakery.improve.business.service.impl.MenuServiceImpl
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuController(val menuServiceImpl: MenuServiceImpl) {

}