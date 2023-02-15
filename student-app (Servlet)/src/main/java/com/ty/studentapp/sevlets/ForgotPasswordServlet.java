package com.ty.studentapp.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

public class ForgotPasswordServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("mail");
		String pass1 = req.getParameter("newpass");
		int newPass = Integer.parseInt(pass1);
		String pass2 = req.getParameter("repass");
		int rePass = Integer.parseInt(pass2);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		Student s = new Student();
		
		s.setEmailId(email);
		s.setPassword(pass1);
		s.setPassword(pass2);
		
		boolean isUpdated = operation.forgetPassword(email, pass1);
		
		if (isUpdated) {
			out.print("<h1>Password Updated Sucessfully !!!</h1>");
		} else {
			out.print("<h1>Password NOT Updated</h1>");
		}
	}
	
}
