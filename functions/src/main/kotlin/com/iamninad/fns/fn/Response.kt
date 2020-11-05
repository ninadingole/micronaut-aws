package com.iamninad.fns.fn

import io.micronaut.core.annotation.Introspected

@Introspected
data class Response(val id: String, val isSuccess: Boolean)