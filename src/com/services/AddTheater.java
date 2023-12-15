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
 * Servlet implementation class AddTheater
 */
@WebServlet("/AddTheater")
public class AddTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTheater() {
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
		String tt = request.getParameter("tt");
		String ns = request.getParameter("ns");
		String cn = request.getParameter("cn");
		String em = request.getParameter("em");
		String ci = request.getParameter("ci");
		String ad = request.getParameter("ad");
		String lo = request.getParameter("lo");
		
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into theater_tab values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,tid);
			ps1.setString(2,tnm);
			ps1.setString(3, ns);
			ps1.setString(4, ci);
			ps1.setString(5, tt);
			ps1.setString(6, ad);
			ps1.setString(7, em);
			ps1.setString(8, cn);
			ps1.setString(9, lo);
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
