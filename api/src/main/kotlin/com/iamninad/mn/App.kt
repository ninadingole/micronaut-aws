package com.iamninad.mn

import io.micronaut.runtime.Micronaut
import org.slf4j.LoggerFactory

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        LoggerFactory.getLogger(App.javaClass).info("Starting app...")
        Micronaut.build()
                .packages("com.iamninad")
                .mainClass(App.javaClass)
                .start()
    }
}