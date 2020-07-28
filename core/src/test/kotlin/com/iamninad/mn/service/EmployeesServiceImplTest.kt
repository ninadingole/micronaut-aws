package com.iamninad.mn.service

import com.iamninad.mn.model.Employee
import com.iamninad.mn.repository.EmployeeRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.*

class EmployeesServiceImplTest : StringSpec({

    val mockRepository = mockk<EmployeeRepository>()
    val service = EmployeesServiceImpl(mockRepository)

    @AnnotationSpec.BeforeEach
    fun setUp() = clearAllMocks()

    "list" {
        every { mockRepository.getAll() } returns Arrays.asList(createEmployee())

        val actual = service.list()
        actual.count() shouldBe 1
        verify { mockRepository.getAll() }
    }

    "delete" {
        every { mockRepository.delete(any()) } returns true

        service.delete(1)

        verify(timeout = 3000) {
            mockRepository.delete(1)
        }
    }

    "add" {

        val employee = createEmployee()
        every { mockRepository.add(any()) } returns createEmployee()

        val actual = service.add(employee)
        actual.id shouldNotBe ""
        actual.name shouldBe "Test"
        verify { mockRepository.add(employee) }
    }

})

private fun createEmployee() = Employee(1, "Test", "", "",
        "", "", "Pune")
