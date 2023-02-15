package com.ty.studentapp.sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

@WebServlet("/display-all")
public class DisplayAllStudents extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		RequestDispatcher dis = req.getRequestDispatcher("/after-login.html");
		dis.include(req, resp);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		ArrayList<Student> allStudents =  operation.getAllStudents();
		
		String htmlTable = "<table border='1' align='center'>"
				+ "<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "<th>Marks</th>"
				+ "<th>Email ID</th>"
				+ "<th colspan='2'>Actions</th>"
				+ "</tr>";
		
		for (Student student : allStudents) {
			String tableRow = "<tr>"
					+ "<td>"+student.getId()+"</td>"
					+ "<td>"+student.getName()+"</td>"
					+ "<td>"+student.getMarks()+"</td>"
					+ "<td>"+student.getEmailId()+"</td>"
							+ "<td><a href='./update?id="+student.getId()+"'>EDIT</td>"
							+ "<td><a href='./delete?id="+student.getId()+"'>DELETE</td>"
					+ "</tr>";
			
			htmlTable = htmlTable + tableRow;
		}
		
		htmlTable = htmlTable + "<table>";
		
		out.print(htmlTable);
	}
	
}
