package com.iamninad.mn.service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe

class TestSpec : DescribeSpec() {
    init {
        describe("Foo") {
            it("works") {
                val foo: String? = null
                (foo) shouldNotBe null
            }
        }
    }
}