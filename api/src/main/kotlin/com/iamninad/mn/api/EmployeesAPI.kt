package com.iamninad.mn.api

import com.iamninad.mn.model.Employee
import com.iamninad.mn.service.EmployeesService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.reactivex.Single
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.stream.Stream
import javax.inject.Inject

@Controller("/employees")
class EmployeesAPI {

    internal val employees: ConcurrentHashMap<String, Employee> = ConcurrentHashMap()

    @Inject
    lateinit var service: EmployeesService

    @Get("/")
    fun list(): Stream<Employee> {
        return employees.values.stream()
    }

    @Post("/")
    fun add(@Body employee: Single<Employee>): Single<Employee> {
        return employee.map {
            it.id = UUID.randomUUID().toString()
            employees[it.id!!] = it
            it
        }
    }

    @Delete("/{id}")
    fun delete(id: String): HttpStatus {
        return employees.remove(id).let {
            when (it) {
                is Employee -> HttpStatus.GONE
                else -> HttpStatus.NOT_FOUND
            }
        }
    }


}