package com.iamninad.mn.repository

import com.iamninad.mn.model.Employee
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

interface EmployeeRepository {
    fun add(employee: Employee): Employee
    fun getAll(): List<Employee>
    fun delete(id: String): Employee?
}

@Singleton
class InMemoryEmployeeRepository : EmployeeRepository {

    private val employees: ConcurrentHashMap<String, Employee> = ConcurrentHashMap()

    override fun add(employee: Employee): Employee {
        employees[employee.id!!] = employee
        return employee
    }

    override fun getAll(): List<Employee> {
        return employees.values.toList()
    }

    override fun delete(id: String): Employee? {
        return  employees.remove(id)
    }

}