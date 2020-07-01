package com.iamninad.mn.function

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import java.util.function.Function

@FunctionBean("aws-kotlin-jvm-gradle-dev-micronaut-aws")
class MicronautAwsFunction : FunctionInitializer(), Function<APIGatewayProxyRequestEvent, ApiGatewayResponse> {

    override fun apply(event : APIGatewayProxyRequestEvent) : ApiGatewayResponse {
        val objectMapper = ObjectMapper()
        val request = objectMapper.readValue(event.body, FunctionRequest::class.java)
        return ApiGatewayResponse.build {
             statusCode = 200
             objectBody = FunctionResponse(request.someValue, request.message, true)
             headers = mapOf()
         }

    }
}

/**
 * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar
 * where the argument to echo is the JSON to be parsed.
 */
fun main(args: Array<String>) {
    val function = MicronautAwsFunction()
    function.run(args, { context -> function.apply(context.get(APIGatewayProxyRequestEvent::class.java)) })
}