package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//try {
			   Connection users = null;
			   try {
			    //request.setCharacterEncoding("utf-8");
			    //Class.forName("com.mysql.jdbc.Driver");
			    //users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8","root","");
			    users = DBConnection.openConnection();
			    String id = request.getParameter("updateId");
			    String name=request.getParameter("updateName");
			    String picture = request.getParameter("updatePicture");
			    Statement state = users.createStatement();

			     if(name.length()!=0){
			    	state.executeUpdate("UPDATE user_table SET name='" + name + "' WHERE id ='" + id + "'");
			    }
			     if(picture.length()!=0){
				    	state.executeUpdate("UPDATE user_table SET picture='" + picture + "' WHERE id ='" + id + "'");
				    }
			     DBConnection.closeConnection(users, state);
			    //state.close();
			    //users.close();
			    response.sendRedirect("/select");
			   //} catch(ClassNotFoundException e) {
			    //e.printStackTrace();
			   //}
			  } catch(SQLException e){
			   e.printStackTrace();
			  }
	}
	}


