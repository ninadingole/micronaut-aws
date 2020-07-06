package com.iamninad.mn

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.slf4j.LoggerFactory

@OpenAPIDefinition(
        info = Info(
                title = "Employees API",
                version = "0.1"
        )
)
object App {
    @JvmStatic
    fun main(args: Array<String>) {
        LoggerFactory.getLogger(App.javaClass).info("Starting app...")
        Micronaut.build()
                .args(*args)
                .packages("com.iamninad")
                .mainClass(App.javaClass)
                .start()
    }
}