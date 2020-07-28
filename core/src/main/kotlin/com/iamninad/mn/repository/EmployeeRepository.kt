package com.iamninad.mn.repository

import com.iamninad.mn.model.Employee
import io.micronaut.tracing.annotation.ContinueSpan
import java.util.concurrent.ConcurrentHashMap

interface EmployeeRepository {
    fun add(employee: Employee): Employee
    fun getAll(): List<Employee>
    fun delete(id: Long): Boolean
}

open class InMemoryEmployeeRepository : EmployeeRepository {

    private val employees: ConcurrentHashMap<Long, Employee> = ConcurrentHashMap()

    @ContinueSpan
    override fun add(employee: Employee): Employee {
        employees[employee.id!!] = employee
        return employee
    }

    @ContinueSpan
    override fun getAll(): List<Employee> {
        return employees.values.toList()
    }

    override fun delete(id: Long): Boolean {
        if(employees.remove(id) != null) {
            return true
        }
        return false
    }
}