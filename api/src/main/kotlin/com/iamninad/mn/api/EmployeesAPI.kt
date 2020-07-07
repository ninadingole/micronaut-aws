package com.iamninad.mn.api

import com.iamninad.mn.model.Employee
import com.iamninad.mn.service.EmployeesService
import io.micronaut.http.HttpResponse
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
    open fun add(@SpanTag("post.employee") @Body employee: Employee): HttpResponse<Employee> {
        LOG.info("employee add")
        return service.add(employee)
                .takeIf { !it.id.isNullOrEmpty() }
                .let { HttpResponse.created(it!!) }
    }

    @Delete("/{id}")
    fun delete(id: String): HttpResponse<Void> {
        LOG.info("employee delete")
        return when (service.delete(id)) {
            true -> HttpResponse.status(HttpStatus.GONE)
            else -> HttpResponse.status(HttpStatus.NOT_FOUND)
        }
    }


}