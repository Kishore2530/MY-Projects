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

public class SearchStudentServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String sid = req.getParameter("stuid");
		int stuid = Integer.parseInt(sid);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		Student stu = operation.getStudent(stuid);
		
		HttpSession session = req.getSession(false);
		
		String table = "<table border='2' align='center' margin-top='30px'>"
				+ "<tr>"
				+ "<th>Student ID</th>"
				+ "<th>Student Name</th>"
				+ "<th>Marks</th>"
				+ "<th>Email ID</th>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>"+stu.getId()+"</td>"
				+ "<td>"+stu.getName()+"</td>"
				+ "<td>"+stu.getMarks()+"</td>"
				+ "<td>"+stu.getEmailId()+"</td>"
				+ "</tr>"
				+ "</table>";
		
		if (stu != null) {
			RequestDispatcher dis = req.getRequestDispatcher("/after-login.html");
			dis.include(req, resp);
			out.print(table);
		} 
		if (stu == null) {
			out.print("<h1>No Records Found</h1>");
		}
		
	}
	
}
	