

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ringdisplay
 */
public class ringdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ringdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String material=request.getParameter("material");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		String DeleteUrl = "deletering?id=" +id;
		String EditUrl = "editring?id="+id+"&material="+material+"&price="+price+"&rating="+rating;
		
		out.println("<html>");
		out.println("<body align=center>");
		out.println("<h2>Ring's Details</h2>");
		out.println("<br>Ring material:"+material);
		out.println("<br>Ring Price:  "+price);
		out.println("<br>Ring's Rate:  "+rating);
		
		out.println("<br><br><a href='"+DeleteUrl+"'>"+"Delete Ring"+"</a><br>");
		out.println("<br><a href='"+EditUrl+"'>"+"Edit"+"</a><br>");
		out.println("</body");
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
