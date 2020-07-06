package com.iamninad.mn.api

import com.iamninad.mn.model.Employee
import com.iamninad.mn.service.EmployeesService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.tracing.annotation.NewSpan
import io.micronaut.tracing.annotation.SpanTag
import org.slf4j.LoggerFactory
import java.util.stream.Stream
import javax.inject.Inject

@Controller("/employees")
open class EmployeesAPI {

    private val LOG = LoggerFactory.getLogger(EmployeesAPI::class.java)

    @Inject
    lateinit var service: EmployeesService

    @Get
    @NewSpan
    open fun list(): Stream<Employee> {
        LOG.info("employee list")
        return service.list()
    }

    @Post
    @NewSpan
    open fun add(@SpanTag("post.employee") @Body employee: Employee): Employee {
        LOG.info("employee add")
        return service.add(employee)
    }

    @Delete("/{id}")
    fun delete(id: String): HttpStatus {
        LOG.info("employee delete")
        return when (service.delete(id)) {
            true -> HttpStatus.GONE
            else -> HttpStatus.NOT_FOUND
        }
    }


}