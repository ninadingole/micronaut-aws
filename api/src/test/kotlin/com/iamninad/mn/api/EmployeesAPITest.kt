package com.iamninad.mn.api

import com.iamninad.mn.model.Employee
import com.iamninad.mn.service.EmployeesService
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest.*
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class EmployeesAPITest(private val service: EmployeesService,
                       @Client("/") client: RxHttpClient) : StringSpec({

    "should list all the employees" {
        val mock = getMock(service)
        every { mock.list() } returns listOf(createEmployee()).stream()
        val request = GET<String>("/employees")
        val retrieve = client.toBlocking().exchange(request, Argument.STRING)
        retrieve.status shouldBe HttpStatus.OK
        retrieve.body() shouldBe """[{"id":"1","name":"Test","emailId":"abc@gmail.com","mobile":"9100000000","department":"Banking","address":"Sample Address","location":"Pune","skills":["Java","Kotlin"]}]"""
    }

    "should add employee and return 201 Created" {
        val mock = getMock(service)
        every { mock.add(any()) } returns createEmployee()
        val request = POST("/employees", """{"id":"1","name":"Test","emailId":"abc@gmail.com","mobile":"9100000000","department":"Banking","address":"Sample Address","location":"Pune","skills":["Java","Kotlin"]}""")
        val response = client.toBlocking().exchange(request, Argument.STRING)
        response.status shouldBe HttpStatus.CREATED
        response.body() shouldBe """{"id":"1","name":"Test","emailId":"abc@gmail.com","mobile":"9100000000","department":"Banking","address":"Sample Address","location":"Pune","skills":["Java","Kotlin"]}"""
    }

    "delete should return 410 GONE if employee is deleted" {
        val mock = getMock(service)
        every { mock.delete(any()) } returns true
        val request = DELETE<HttpStatus>("/employees/1")
        try {
            client.toBlocking().exchange(request, Argument.VOID)
        } catch (e: HttpClientResponseException) {
            e.status shouldBe HttpStatus.GONE
        }
    }

    "delete should return 404 Not Found if employee is not available" {
        val mock = getMock(service)
        every { mock.delete(any()) } returns false
        val request = DELETE<HttpStatus>("/employees/1")
        try {
            client.toBlocking().exchange(request, Argument.VOID)
        } catch (e: HttpClientResponseException) {
            e.status shouldBe HttpStatus.NOT_FOUND
        }
    }

}) {
    @MockBean(EmployeesService::class)
    fun employeeService(): EmployeesService = mockk()
}

fun createEmployee(): Employee = Employee(1, "Test",
        "abc@gmail.com",
        "9100000000",
        "Banking",
        "Sample Address",
        "Pune")
