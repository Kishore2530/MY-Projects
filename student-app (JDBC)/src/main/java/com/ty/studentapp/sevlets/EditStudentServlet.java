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

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Student stu = new Student();
		
		String sId = req.getParameter("sid");
		int id = Integer.parseInt(sId);
		String name = req.getParameter("sname");
		String sMark = req.getParameter("smark");
		Double marks = Double.parseDouble(sMark);
		String mail = req.getParameter("smail");
		
		stu.setId(id);
		stu.setName(name);
		stu.setMarks(marks);
		stu.setEmailId(mail);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		operation.updateDetails(stu);
		
		RequestDispatcher dis = req.getRequestDispatcher("/display-all");
		dis.forward(req, resp);
	}
	
}
