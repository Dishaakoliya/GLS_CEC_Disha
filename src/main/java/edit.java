

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String material=request.getParameter("material");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		out.println("update details");
		
		out.println("<html>");
		out.println("<body align=center border=2>");
		out.println("<form action='editring' method='post'>");
		out.println("<table>");
		out.println("<tr><td>id</td><td><input type='hidden' name='id' value='"+id+"'><\td></tr>");
		out.println("<tr><td>Material:</td><td><input type='text' name='material' value='"+material+"'></td></tr>");
		out.println("<tr><td>Price:</td><td><input type='text' name='price' value='"+price+"'></td></tr>");
		out.println("<tr><td>Rating:</td><td><input type='text' name='rating' value='"+rating+"'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
