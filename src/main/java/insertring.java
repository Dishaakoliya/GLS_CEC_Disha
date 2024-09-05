

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

/**
 * Servlet implementation class insertring
 */
public class insertring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertring() {
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
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String material=request.getParameter("material");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Dish@123");
			String insert="insert into ring(material,price,rating)values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert);

		    ps.setString(1, material);
		    ps.setString(2, price);
		    ps.setString(3, rating);
		    
		    ps.executeUpdate();
		    out.println("<html>");
		    out.println("<body>");
		    out.println("<h2>Successfully Insert ringdata</h2>");
		    out.println("<a href=\"detalis.jsp\">Show details</a>");
		    out.println("</body>");
		    out.println("</html>");
		}
	
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
