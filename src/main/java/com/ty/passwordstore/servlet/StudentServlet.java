package com.ty.passwordstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("stuName");
		String email = req.getParameter("stuMail");

		String html = "<html><body><h1>Name " + name + "</h1>" + "<h1>Email " + email + "</h1>" + "</body></html>";

		PrintWriter printWriter = resp.getWriter();
		printWriter.write(html);

	}
}
