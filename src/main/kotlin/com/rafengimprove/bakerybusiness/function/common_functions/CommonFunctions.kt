package com.rafengimprove.bakerybusiness.function.common_functions

import org.apache.tomcat.util.IntrospectionUtils
import java.util.*

fun nameGenerator(): String {
    var name = ""
    for (i in 1..Random().nextInt(5, 9)) {
        name += ('a'..'z').random()
    }
    return (IntrospectionUtils.capitalize(name))
}

