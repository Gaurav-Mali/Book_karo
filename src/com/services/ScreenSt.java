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
 * Servlet implementation class ScreenSt
 */
@WebServlet("/ScreenSt")
public class ScreenSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenSt() {
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
		int tid = Integer.parseInt(request.getParameter("tid"));
		String tnm = request.getParameter("tnm");
		
		String sc = request.getParameter("sc");
		String ct = request.getParameter("ct");
		String cs = request.getParameter("cs");
		String ts = request.getParameter("ts");
		String av = request.getParameter("av");
	
		
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into avail_tab values(?,?,?,?,?,?,?)");
			ps1.setInt(1,tid);
			ps1.setString(2,tnm);
			ps1.setString(3, sc);
			ps1.setString(4, ct);
			ps1.setString(5, cs);
			ps1.setString(6, ts);
			ps1.setString(7, av);
			
			int i = ps1.executeUpdate();
			
			if(i>0)
			{
				
				response.sendRedirect("ManagerDash.html");
				
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
