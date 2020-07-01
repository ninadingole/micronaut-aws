package com.iamninad.mn.function

import io.micronaut.core.annotation.Introspected

@Introspected
data class FunctionResponse(var outValue: Int, var outMessage: String, var someBool: Boolean)
