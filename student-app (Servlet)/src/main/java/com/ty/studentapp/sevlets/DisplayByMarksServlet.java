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

@WebServlet("/by-marks")
public class DisplayByMarksServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String high = req.getParameter("high");
		double highMark = Double.parseDouble(high);
		String low = req.getParameter("low");
		double lowMark = Double.parseDouble(low);
		
		RequestDispatcher dis = req.getRequestDispatcher("/after-login.html");
		dis.include(req, resp);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		ArrayList<Student> basedOnMarks = operation.getStudentsBasedOnMarks(lowMark, highMark);
		
		String htmlTable = "<table border='1' align='center'>"
				+ "<tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "<th>Marks</th>"
				+ "<th>Email ID</th>"
				+ "</tr>";
		
		for (Student student : basedOnMarks) {
			
			String tableRow = "<tr>"
					+ "<td>"+student.getId()+"</td>"
					+ "<td>"+student.getName()+"</td>"
					+ "<td>"+student.getMarks()+"</td>"
					+ "<td>"+student.getEmailId()+"</td>"
					+ "</tr>";
			
			htmlTable = htmlTable + tableRow;
		}
		
			htmlTable = htmlTable + "<table>";
		
			out.print(htmlTable);
	}
	
}
