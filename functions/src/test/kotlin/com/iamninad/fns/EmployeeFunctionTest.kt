package com.iamninad.fns

import com.amazonaws.services.lambda.runtime.Context
import com.iamninad.fns.fn.EmployeeFunction
import com.iamninad.fns.fn.EmployeeRequest
import com.iamninad.fns.fn.Response
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.context.ApplicationContext
import io.micronaut.function.client.FunctionClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import javax.inject.Named


@FunctionClient
interface EmployeeFunctionClient {

    @Named("employees-fn")
    fun apply(input: EmployeeRequest): Response

}

@MicronautTest
class EmployeeFunctionTest() : StringSpec({

    "should call the function" {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val handler = EmployeeFunction()
        val ctx = server.applicationContext.getBean(Context::class.java)
        var ef = handler.buildApplicationContext(ctx)

//        var server = ApplicationContext.run(EmbeddedServer::class.java)
//        val client = server.applicationContext.getBean(EmployeeFunctionClient::class.java)
        var response = handler.handleRequest(EmployeeRequest("1", "Ninad"), ctx)
        response.id shouldBe "1"
        response.isSuccess shouldBe true
        println("")
    }

})
