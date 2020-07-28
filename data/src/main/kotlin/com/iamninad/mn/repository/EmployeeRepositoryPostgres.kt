package com.iamninad.mn.repository

import com.iamninad.mn.model.Employee
import javax.inject.Singleton

@Singleton
class EmployeeRepositoryPostgres(private val repository: EmployeeJDBCRepository) : EmployeeRepository {

    override fun add(employee: Employee): Employee = repository.save(employee)

    override fun getAll(): List<Employee> = repository.findAll().toList()

    override fun delete(id: Long): Boolean = repository.findById(id).map {
        repository.delete(it)
        true
    }.orElse(false)


}