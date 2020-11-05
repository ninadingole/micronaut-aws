package com.iamninad.fns.fn

import com.amazonaws.services.lambda.runtime.Context
import io.micronaut.context.ApplicationContext
import io.micronaut.function.FunctionBean
import io.micronaut.function.aws.MicronautRequestHandler
import java.util.function.Function

@FunctionBean("employees-fn")
open class EmployeeFunction: MicronautRequestHandler<EmployeeRequest, Response>() {


    override fun execute(input: EmployeeRequest): Response {
        println(input)
        return Response(input.id, true)
    }

    fun apply(input: EmployeeRequest): Response {
        println(input)
        return Response(input.id, true)
    }

    public override fun buildApplicationContext(context: Context?): ApplicationContext {
        return super.buildApplicationContext(context)
    }
}

