package micronaut.aws

import io.micronaut.core.annotation.Introspected

@Introspected
data class FunctionRequest(var someValue: Int, var message: String)
