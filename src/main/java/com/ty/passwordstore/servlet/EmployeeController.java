package com.ty.passwordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.passwordstore.dto.Employee;
import com.ty.passwordstore.service.EmployeeService;

public class EmployeeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("empName");
		String phone = req.getParameter("empPhone");
		String address = req.getParameter("empAddr");
		String gender = req.getParameter("empGender");
		String role = req.getParameter("empRole");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setGender(gender);
		employee.setPhone(Long.parseLong(phone));
		employee.setRole(role);

		EmployeeService employeeService = new EmployeeService();
		employee = employeeService.saveEmployee(employee);
		PrintWriter printWriter = resp.getWriter();
		if (employee != null) {

			String html = "<html><body><h1>" + employee.getName() + " registered successfully with id " + employee.getId()
					+ " & assigned " + employee.getRole() + " role" + "</h1></body></html>";
			printWriter.write(html);
		} else {
			printWriter.write("<html><body><h1>Registration Failed !!</h1></body></html>");
		}
	}

}
