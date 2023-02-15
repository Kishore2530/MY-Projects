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

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String stuid = req.getParameter("id");
		int id = Integer.parseInt(stuid);
		
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		operation.idDelete(id);
		
		RequestDispatcher dis = req.getRequestDispatcher("/after-login.html");
		dis.include(req, resp);
		
		RequestDispatcher dis1 = req.getRequestDispatcher("/display-all");
		dis1.forward(req, resp);
		
	}
	
}
