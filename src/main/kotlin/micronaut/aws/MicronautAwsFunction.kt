package micronaut.aws;

import io.micronaut.function.executor.FunctionInitializer
import io.micronaut.function.FunctionBean;
import javax.inject.*;
import java.util.function.Function;

@FunctionBean("aws-kotlin-jvm-gradle-dev-micronaut-aws")
class MicronautAwsFunction : FunctionInitializer(), Function<FunctionRequest, FunctionResponse> {

    override fun apply(request : FunctionRequest) : FunctionResponse {
         return  FunctionResponse(request.someValue, request.message, true)

    }   
}

/**
 * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar 
 * where the argument to echo is the JSON to be parsed.
 */
fun main(args : Array<String>) { 
    val function = MicronautAwsFunction()
    function.run(args, { context -> function.apply(context.get(FunctionRequest::class.java))})
}