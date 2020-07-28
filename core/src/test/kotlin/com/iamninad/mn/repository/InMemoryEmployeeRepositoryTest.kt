package com.iamninad.mn.repository

import com.iamninad.mn.model.Employee
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InMemoryEmployeeRepositoryTest : StringSpec({

    val repository = InMemoryEmployeeRepository()

    "should add employee to inmemory map" {
        val testEmployee = createEmployee()
        repository.add(testEmployee)
        val allEmployees = repository.getAll()
        allEmployees.size shouldBe 1
        allEmployees[0] shouldBe testEmployee
    }

    "delete" {
        val testEmployee = createEmployee()
        repository.add(testEmployee)
        repository.delete(1)
        val allEmployees = repository.getAll()
        allEmployees.size shouldBe 0
    }
})

private fun createEmployee() = Employee(1, "Test", "adb@sample.com", "9100000000",
        "Sales", "Wagholi", "Pune")
