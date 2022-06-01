package com.ty.passwordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.passwordstore.dao.UserDao;
import com.ty.passwordstore.dto.User;
import com.ty.passwordstore.service.UserService;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("mail");
		String password = req.getParameter("pwd");
		String gender = req.getParameter("gender");

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setPassword(password);

		UserService service = new UserService();
		user = service.saveUser(user);
		PrintWriter printWriter = resp.getWriter();

		if (user != null) {
			String html = "<html><body><h1>" + user.getName() + " Registered Successfully & your id is " + user.getId()
					+ "</h1></body></html>";

			printWriter.write(html);
		} else {
			printWriter.write("<html><body><h1>Registered Failed !!</h1>></body></html>");

		}
	}

}
