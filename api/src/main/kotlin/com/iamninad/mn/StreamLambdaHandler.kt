package com.iamninad.mn

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.io.OutputStream

class StreamLambdaHandler : RequestStreamHandler {

    private val LOG = LoggerFactory.getLogger(StreamLambdaHandler::class.java)

    companion object {
        lateinit var handler: MicronautLambdaContainerHandler
    }

    init {
        try {
            handler = MicronautLambdaContainerHandler()
        }catch (e: ContainerInitializationException) {
            LOG.error(e.message, e)
            throw RuntimeException("Could not initialize Micronaut", e)
        }
    }


    override fun handleRequest(input: InputStream?, output: OutputStream?, context: Context?) {
        handler.proxyStream(input, output, context)
    }

}