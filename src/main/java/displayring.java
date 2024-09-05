

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class displayring
 */
public class displayring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayring() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String material=request.getParameter("material");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Dish@123");
			String display="select * from ring";
			PreparedStatement ps=con.prepareStatement(display);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String id=rs.getString(1);
				material=rs.getString(2);
				price=rs.getString(3);
				rating=rs.getString(4);
				
				String LinkUrl="ringdisplay?material="+material+"&price="+price+"&rating="+rating+"&id="+id;
				out.println("<html>");
				out.println("<body>");
				out.println("<br><a href='"+LinkUrl+"'>"+material+"</a>");
//				out.println("<br><br><a href=\"ringdisplay\">show data</a>");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
