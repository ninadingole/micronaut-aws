package com.iamninad.mn.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class EmployeeList(val employees: List<Employee>)