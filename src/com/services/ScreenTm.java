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
 * Servlet implementation class ScreenTm
 */
@WebServlet("/ScreenTm")
public class ScreenTm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenTm() {
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
		
		String ns = request.getParameter("sc");
		String cn = request.getParameter("ti");
		String em = request.getParameter("sh");
	
		
		try
		{
			Connection con = Connectdb.getConnect();
			PreparedStatement ps1 = con.prepareStatement("insert into show_tab values(?,?,?,?,?)");
			ps1.setInt(1,tid);
			ps1.setString(2,tnm);
			ps1.setString(3, ns);
			ps1.setString(4, cn);
			ps1.setString(5, em);
			
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
