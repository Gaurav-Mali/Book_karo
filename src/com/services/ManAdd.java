package com.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connectdb.Connectdb;

/**
 * Servlet implementation class ManAdd
 */
@WebServlet("/ManAdd")
public class ManAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManAdd() {
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
		String nm = request.getParameter("nm");
		String em = request.getParameter("em");
		String ph = request.getParameter("ph");
		String mb = request.getParameter("mb");
		String st = request.getParameter("st");
		String ct = request.getParameter("ct");
		String un = request.getParameter("un");
		String pass = request.getParameter("pass");
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into manager_tab values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2,nm);
			ps1.setString(3, em);
			ps1.setString(4, ph);
			ps1.setString(5, mb);
			ps1.setString(6, ct);
			ps1.setString(7, st);
			ps1.setString(8, un);
			ps1.setString(9, pass);
			int i = ps1.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("AdminDash.html");
				
			}
			else
			{
				response.sendRedirect("error.html");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
