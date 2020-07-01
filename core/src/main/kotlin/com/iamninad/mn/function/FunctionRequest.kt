package com.iamninad.mn.function

import io.micronaut.core.annotation.Introspected

@Introspected
class FunctionRequest {
    var someValue: Int = -1
    lateinit var message: String
}
