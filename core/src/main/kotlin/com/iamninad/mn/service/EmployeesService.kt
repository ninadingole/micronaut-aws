package com.iamninad.mn.service

import com.iamninad.mn.model.Employee
import javax.inject.Singleton

interface EmployeesService {
    fun list(): Array<Employee>
    fun add(employee: Employee): Employee
    fun delete(id: String): Boolean
}

@Singleton
class EmployeesServiceImpl: EmployeesService {

    override fun list(): Array<Employee> {
        TODO("Not yet implemented")
    }

    override fun add(employee: Employee): Employee {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

}