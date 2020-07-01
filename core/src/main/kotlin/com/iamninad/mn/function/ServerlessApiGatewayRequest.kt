package com.iamninad.mn.function

import io.micronaut.core.annotation.Introspected


@Introspected
data class ServerlessApiGatewayRequest(var body: FunctionRequest,
                                       var method: String,
                                       var principalId: String,
                                       var stage: String)