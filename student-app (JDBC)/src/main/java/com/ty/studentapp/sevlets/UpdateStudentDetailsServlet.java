package com.ty.studentapp.sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

@WebServlet("/update")
public class UpdateStudentDetailsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String stuId = req.getParameter("id");
		int id = Integer.parseInt(stuId);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		Student stu = operation.getStudent(id);
		
		RequestDispatcher dispatch = req.getRequestDispatcher("/after-login.html");
		dispatch.include(req, resp);
		
		String htmlForm = "<div class=\"container\">\r\n"
				+ "		\r\n"
				+ "		<form action=\"edit\" method=\"GET\" class=\"form\">\r\n"
				+ "			<label>Student ID <sup class=\"sup\">*</sup></label> <br>\r\n"
				+ "			<input type=\"text\" name=\"sid\" required=\"required\" value="+stu.getId()+" readonly>\r\n"
				+ "			<br><br>\r\n"
				+ "			\r\n"
				+ "			<label>Name <sup class=\"sup\">*</sup></label> <br>\r\n"
				+ "			<input type=\"text\" name=\"sname\" required=\"required\" value="+stu.getName()+">\r\n"
				+ "			<br><br>		\r\n"
				+ "			\r\n"
				+ "			<label>Marks <sup class=\"sup\">*</sup></label> <br>\r\n"
				+ "			<input type=\"text\" name=\"smark\" required=\"required\" value="+stu.getMarks()+">\r\n"
				+ "			<br><br>\r\n"
				+ "			\r\n"
				+ "			<label>Email ID <sup class=\"sup\">*</sup></label> <br>\r\n"
				+ "			<input type=\"email\" name=\"smail\" required=\"required\" value="+stu.getEmailId()+">\r\n"
				+ "			<br><br>\r\n"
				+ "			\r\n"
				+ "			<input type=\"submit\" value=\"UPDATE\" class=\"buttons\">\r\n"
				+ "		</form>\r\n"
				+ "	</div>";
		
		out.print(htmlForm);
		
	}
	
}
