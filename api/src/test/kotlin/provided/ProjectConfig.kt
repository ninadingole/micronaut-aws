package provided

import io.kotlintest.AbstractProjectConfig

object ProjectConfig : AbstractProjectConfig() {
    override fun parallelism(): Int = 3
}
