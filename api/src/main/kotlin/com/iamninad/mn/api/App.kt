package com.iamninad.mn.api

import io.micronaut.runtime.Micronaut

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.iamninad")
                .mainClass(App.javaClass)
                .start()
    }
}