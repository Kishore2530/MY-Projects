package com.ty.studentapp.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

public class LoginStudentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		Student stu = operation.logInValidate(mail, pass);
		
		HttpSession sesssion = req.getSession(true);
		
		if (stu == null) {
			out.print("<h1 color='red'>Something Went Wrong</h1>");
			RequestDispatcher dispatch = req.getRequestDispatcher("/login.html");
			dispatch.include(req, resp);
		} else {
			RequestDispatcher dis = req.getRequestDispatcher("/after-login.html");
			dis.forward(req, resp);
		}
	}
	
}
