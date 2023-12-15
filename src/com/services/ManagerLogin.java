package com.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectdb.Connectdb;


/**
 * Servlet implementation class ManagerLogin
 */
@WebServlet("/ManagerLogin")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String hnam = request.getParameter("em");
		String hpa = request.getParameter("pass");
		
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps3 = con.prepareStatement("select * from manager_tab where memail_ct=? and pwd_ct=?");
			ps3.setString(1, hnam);
			ps3.setString(2, hpa);
			ResultSet rs = ps3.executeQuery();
			while(rs.next())
			{
				IdSet.setRid_ct(rs.getInt("rid_ct"));
				response.sendRedirect("ManagerDash.html");
			}
			response.sendRedirect("error.html");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
