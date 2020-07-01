package com.iamninad.mn.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class Employee(var id: String?,
                    val name: String,
                    val emailId: String,
                    val mobile: String,
                    val department: String,
                    val address: String,
                    val location: String,
                    val skills: Array<String>)