package com.iamninad.mn.model

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
@Schema(name="EmployeeList")
data class EmployeeList(val employees: List<Employee>)