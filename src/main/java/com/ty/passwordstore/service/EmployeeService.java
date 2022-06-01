package com.ty.passwordstore.service;

import com.ty.passwordstore.dao.EmployeeDao;
import com.ty.passwordstore.dto.Employee;

public class EmployeeService {

	public Employee saveEmployee(Employee employee) {
		return new EmployeeDao().saveEmployee(employee);
	}

}
