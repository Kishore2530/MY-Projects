package com.ty.studentapp.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

public class RegistrationStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt((req.getParameter("sid")));
		String name = req.getParameter("sname");
		double marks = Double.parseDouble((req.getParameter("smark")));
		String mail = req.getParameter("smail");
		String pass = req.getParameter("spass");
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setMarks(marks);
		s.setEmailId(mail);
		s.setPassword(pass);
		
		String url = "/login.html";
		boolean isInserted = operation.insertStudent(s);
		if (isInserted) {
			RequestDispatcher dispatch = req.getRequestDispatcher(url);
			dispatch.forward(req, resp);
		} else {
			out.print("<h1>Something Went Wrong</h1>");
			out.print("<h2>Try Again</h2>");
			RequestDispatcher dispatch1 = req.getRequestDispatcher("/register-student-form.html");
			dispatch1.include(req, resp);
		}
		
	}
	
}
