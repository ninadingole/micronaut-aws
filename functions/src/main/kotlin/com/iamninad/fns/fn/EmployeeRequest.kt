package com.iamninad.fns.fn

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected
data class EmployeeRequest(
        @JsonProperty("id") val id: String,
        @JsonProperty("name") val name: String)