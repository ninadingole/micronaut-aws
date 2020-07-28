package com.iamninad.mn.repository

import com.iamninad.mn.model.Employee
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface EmployeeJDBCRepository: CrudRepository<Employee, Long>