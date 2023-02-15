package com.ty.studentapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.ty.studentapp.dto.Student;

public class StudentDataBaseOperation {

	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/vdja3_db?user=root&password=root";

	public boolean insertStudent(Student stu) {
		// INSERT INTO student_table VALUES(?,?,?,?,?)

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			Class.forName(DRIVERCLASS);

			con = DriverManager.getConnection(DBURL);

			String query = "INSERT INTO student_table VALUES(?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, stu.getId());
			psmt.setString(2, stu.getName());
			psmt.setDouble(3, stu.getMarks());
			psmt.setString(4, stu.getEmailId());
			psmt.setString(5, stu.getPassword());

			int rowsAffected = psmt.executeUpdate();

			if (rowsAffected != 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}

	public Student logInValidate(String mail, String pass) {
		// SELECT * FROM student_table WHERE email_id = ? AND password = ?
		Connection con1 = null;
		PreparedStatement psmt1 = null;
		ResultSet rs1 = null;

		try {
			Class.forName(DRIVERCLASS);
			con1 = DriverManager.getConnection(DBURL);
			String query = "SELECT * FROM student_table WHERE email_id = ? AND password = ?";
			psmt1 = con1.prepareStatement(query);
			psmt1.setString(1, mail);
			psmt1.setString(2, pass);
			rs1 = psmt1.executeQuery();

			if (rs1.next()) {
				Student s = new Student();
				int id = rs1.getInt(1);
				String name = rs1.getString(2);
				double marks = rs1.getDouble(3);
				String emailId = rs1.getString(4);
				String password = rs1.getString(5);

				s.setId(id);
				s.setName(name);
				s.setMarks(marks);
				s.setEmailId(emailId);
				s.setPassword(password);

				return s;
			} else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con1 != null) {
				try {
					con1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt1 != null) {
				try {
					psmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs1 != null) {
				try {
					rs1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public ArrayList<Student> getAllStudents() {
		// SELECT * FROM student_table
		ArrayList<Student> allStudents = new ArrayList<Student>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "SELECT * FROM student_table";
			smt = con.createStatement();
			rs = smt.executeQuery(query);

			while (rs.next()) {
				Student s = new Student();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double marks = rs.getDouble(3);
				String EmailId = rs.getString(4);

				s.setId(id);
				s.setName(name);
				s.setMarks(marks);
				s.setEmailId(EmailId);

				allStudents.add(s);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return allStudents;
	}

	public ArrayList<Student> getStudent(int stuId) {
		// SELECT * FROM student_table WHERE sid = ?
		ArrayList<Student> searchStudent = new ArrayList<Student>();

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "SELECT * FROM student_table WHERE sid = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, stuId);
			rs = psmt.executeQuery();

			if (rs.next()) {
				Student s = new Student();

				int id = rs.getInt(1);
				String name = rs.getString(2);
				double marks = rs.getDouble(3);
				String EmailId = rs.getString(4);

				s.setId(id);
				s.setName(name);
				s.setMarks(marks);
				s.setEmailId(EmailId);

				searchStudent.add(s);

				return searchStudent;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return null;

	}

	public ArrayList<Student> getStudentsBasedOnMarks(double lowMark, double highMark) {
		// SELECT * FROM student_table WHERE marks BETWEEN ? AND ?
		ArrayList<Student> studentsByMarks = new ArrayList<Student>();

		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "SELECT * FROM student_table WHERE marks BETWEEN ? AND ?";
			psmt = con.prepareStatement(query);

			psmt.setDouble(1, lowMark);
			psmt.setDouble(2, highMark);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Student s = new Student();

				int id = rs.getInt(1);
				String name = rs.getString(2);
				double marks = rs.getDouble(3);
				String EmailId = rs.getString(4);

				s.setId(id);
				s.setName(name);
				s.setMarks(marks);
				s.setEmailId(EmailId);

				studentsByMarks.add(s);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return studentsByMarks;
	}

	public boolean updateDetails(Student st) {
		// UPDATE student_table SET name = ? , marks = ? , email_id = ?

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "UPDATE student_table SET name = ? , marks = ? , email_id = ? WHERE sid = ?";
			psmt = con.prepareStatement(query);

			psmt.setString(1, st.getName());
			psmt.setDouble(2, st.getMarks());
			psmt.setString(3, st.getEmailId());
			psmt.setInt(4, st.getId());

			int rowsAff = psmt.executeUpdate();
			return rowsAff != 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean idDelete(int deleteId) {
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "DELETE FROM student_table WHERE sid = ?";
			psmt = con.prepareStatement(query);

			psmt.setInt(1, deleteId);
			int rowsAff = psmt.executeUpdate();
			return rowsAff != 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean forgetPassword(String mailid, String reTypePass) {
		// UPDATE student_table SET password = ? WHERE email_id = ?

		Connection con = null;
		PreparedStatement psmt = null;

		try {
			Class.forName(DRIVERCLASS);
			con = DriverManager.getConnection(DBURL);
			String query = "UPDATE student_table SET password = ? WHERE email_id = ?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, reTypePass);
			psmt.setString(2, mailid);

			int rowsAff = psmt.executeUpdate();

			return rowsAff != 0;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
