package com.iamninad.mn.service

import com.iamninad.mn.model.Employee
import com.iamninad.mn.repository.EmployeeRepository
import io.micronaut.tracing.annotation.ContinueSpan
import java.util.*
import java.util.stream.Stream
import javax.inject.Inject
import javax.inject.Singleton

interface EmployeesService {
    fun list(): Stream<Employee>
    fun add(employee: Employee): Employee
    fun delete(id: String): Boolean
}

@Singleton
open class EmployeesServiceImpl(@Inject val employeeRepository: EmployeeRepository) : EmployeesService {


    @ContinueSpan
    override fun list(): Stream<Employee> {
        return employeeRepository.getAll().stream()
    }

    @ContinueSpan
    override fun add(employee: Employee): Employee {
        employee.id = UUID.randomUUID().toString()
        return employeeRepository.add(employee)
    }

    override fun delete(id: String): Boolean {
        employeeRepository.delete(id)?.let {
            return true
        }
        return false
    }

}