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
 * Servlet implementation class Seats
 */
@WebServlet("/Seats")
public class Seats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seats() {
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
		
		
		String tnm = request.getParameter("un");
		
		String ph = request.getParameter("ph");
		int tc = Integer.parseInt(request.getParameter("tc"));
		int am = Integer.parseInt(request.getParameter("am"));
		String sh = request.getParameter("sh");
		
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into tickets values(?,?,?,?,?)");
			ps1.setString(1,tnm);
			ps1.setString(2,ph);
			ps1.setInt(3, tc);
			ps1.setInt(4, am);
			ps1.setString(5, sh);
			
			int i = ps1.executeUpdate();
			
			if(i>0)
			{
				
				response.sendRedirect("Success.html");
				
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
