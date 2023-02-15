package com.ty.studentapp.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.ty.studentapp.dao.StudentDataBaseOperation;
import com.ty.studentapp.dto.Student;

public class MainApp {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("****** WELCOME ********");
		StudentDataBaseOperation operation = new StudentDataBaseOperation();
		
		while (true) {
			System.out.println("------------------");
			System.out.println("1.Register\n2.Login\n3.Forgot password\n4.Exit");
			System.out.println("------------------");
			System.out.println("Enter your choice");
			
			int choice =s.nextInt();
			Student st = new Student();
			switch (choice) {
			case 1:
				System.out.println("Enter Student ID");
				int id = s.nextInt();
				System.out.println("Enter Student Name");
				String name = s.next();
				System.out.println("Enter Your Marks");
				double marks = s.nextDouble();
				System.out.println("Enter Your Mail Id");
				String mailId = s.next();
				System.out.println("Enter Your Password");
				String password = s.next();
				
				st.setId(id);
				st.setName(name);
				st.setMarks(marks);
				st.setEmailId(mailId);
				st.setPassword(password);
				
				boolean isInserted = operation.insertStudent(st);
				if (isInserted) {
					System.out.println("Registered Successfully");
				} else {
					System.out.println("Student Details NOT Registered");
				}
				
				break;
			case 2:
				//log in 
				System.out.println("Enter Email ID");
				String mail = s.next();
				System.out.println("Enter your password");
				String pass = s.next();
				Student logedInStudent = operation.logInValidate(mail ,pass);
				if (logedInStudent == null) {
					System.out.println("Invalid Email OR Password !!!");
				} else {
					System.out.println("WELCOME" + " " +logedInStudent.getName());
					
					while (true) {
						System.out.println("************************");
						System.out.println("1.Display All Students\n2.Search\n3.Update\n4.Delete");
						System.out.println("5.Display Based On Marks\n6.Logout");
						System.out.println("*************************");
						System.out.println("Enter your choice");
						int subMenuChoice = s.nextInt();
						
						if (subMenuChoice == 1) {
							//Display all students
							ArrayList<Student> allStudents = operation.getAllStudents();
							System.out.println("ID\t\tName\t\tMarks\t\tEmail ID");
							for (Student s1 : allStudents) {
								System.out.println(s1.getId()+"\t\t"+s1.getName()+"\t\t"+s1.getMarks()+"\t\t"+s1.getEmailId());
							}
						}
						else if (subMenuChoice == 2) {
							//Search
							System.out.println("Enter Student ID");
							int stuId = s.nextInt();
							Student searchedStudents = operation.getStudent(stuId);
							
							if (searchedStudents == null) {
								System.out.println("No Records Found For Student ID" + " " +stuId);
							} else {
								System.out.println("ID\t\tName\t\tMarks\t\tEmail ID");
								System.out.println(searchedStudents.getId()+"\t\t"+searchedStudents.getName()+"\t\t"+searchedStudents.getMarks()+"\t\t"+searchedStudents.getEmailId());
							}
						}
						else if (subMenuChoice == 3) {
							//Update
							int hashCodeBeforeChange = s.hashCode();
							
							System.out.println("Enter Student ID to be Updated");
							int sId = s.nextInt();
							Student stu = operation.getStudent(sId);
							if (stu == null) {
								System.out.println("Data cannot be updated Because Data Is NOT found for ID" + sId);
							} else {
								System.out.println("*********************");
								System.out.println("a.Name\nb.Marks\nc.Email Id");
								System.out.println("*********************");
								System.out.println("Enter Your Choice");
								char updateChoice = s.next().charAt(0);
								if(updateChoice == 'a') {
									System.out.println("Enter Updated Nmae");
									String updatedNmae = s.next();
									stu.setName(updatedNmae);
								}
								else if (updateChoice == 'b') {
									System.out.println("Enter Updated Mark");
									double updatedMark = s.nextDouble();
									stu.setMarks(updatedMark);
								}
								else if(updateChoice == 'c') {
									System.out.println("Enter Updated Email Id");
									String updatedMail = s.next();
									stu.setEmailId(updatedMail);
								}
								else {
									System.out.println("Invalid Update Choice");
								}
								
								int hashCodeAfterChange = s.hashCode();
								
								if (hashCodeBeforeChange != hashCodeAfterChange) {
									boolean stud = operation.updateDetails(stu);
									if (stud) {
										System.out.println("Data Updated");
									} else {
										System.out.println("Data NOT Updated");
									}
								}
							}
						}
						else if (subMenuChoice == 4) {
							//Delete
							//DELETE FROM student_table WHERE sid = ?
							System.out.println("Enter Student ID to be Seleted");
							int deleteId = s.nextInt();
							Student stu = operation.getStudent(deleteId);
							if (stu == null) {
								System.out.println("Id cannot be Deleted Because ID" + deleteId + " NOT Found");
							} else {
								boolean DeletedId = operation.idDelete(deleteId);
								
								if (DeletedId) {
									System.out.println("ID Deleted Successfully");
								} else {
									System.out.println("ID NOT Deleted");
								}
							}
							
						}
						else if (subMenuChoice == 5) {
							//Display based on marks
						
							System.out.println("Enter Low Range Marks");
							double lowMark = s.nextInt();
							System.out.println("Enter High Range Marks");
							double highMark = s.nextInt();
							ArrayList<Student> studentList = operation.getStudentsBasedOnMarks(lowMark,highMark);
							
							if (studentList == null) {
								System.out.println("No Records Found");
							} else {
								System.out.println("ID\t\tName\t\tMarks\t\tEmail ID");
								for (Student s1 : studentList) {
									System.out.println(s1.getId()+"\t\t"+s1.getName()+"\t\t"+s1.getMarks()+"\t\t"+s1.getEmailId());
								}
							}
						}
						else if (subMenuChoice == 6) {
							System.out.println("THANK YOU" + " " + logedInStudent.getName());
							break;
						}
						else {
							System.out.println("Invalid Choice !!!!");
						}
					}
				}
				break;

			case 3:
				//Forget password
				System.out.println("Enter Mail ID");
				String mailid = s.next();
				
				System.out.println("Enter New Password");
				String newPass = s.next();
				
				System.out.println("Retype the New Password");
				String reTypePass = s.next();
				
				while ( ! newPass.equals(reTypePass)) {
					System.out.println("New Password and Retyped Password is NOT Matching");
					
					System.out.println("Enter New Password");
					newPass = s.next();
					
					System.out.println("Retype the New Password");
					reTypePass = s.next();
				}
				
				boolean isUpdated = operation.forgetPassword(mailid,reTypePass);
				
				if (isUpdated) {
					System.out.println("New Password is Updated");
				} else {
					System.out.println("Something Went WRONG While Updating the Password");
				}
				break;

			case 4:
				System.out.println("***** THANK YOU *******");
				System.exit(0);
				break;

			default:
				System.out.println("Invaid Choice !!!");
				break;
			}
		}
	}

}
