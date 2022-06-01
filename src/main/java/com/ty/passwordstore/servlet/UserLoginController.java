package com.ty.passwordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.passwordstore.service.UserService;

public class UserLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("userEmail");
		String pwd = req.getParameter("userPwd");
		PrintWriter printWriter = resp.getWriter();

		UserService service = new UserService();
		if (service.validateUser(email, pwd)) {
			printWriter.write("<html><body><h1>Login successfull</h1></body></html>");
		} else {
			printWriter.write("<html><body><h1>Either email or password is wrong</h1></body></html>");
		}
	}

}
