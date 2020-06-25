package micronaut.aws

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.aws")
                .mainClass(Application.javaClass)
                .start()
    }
}