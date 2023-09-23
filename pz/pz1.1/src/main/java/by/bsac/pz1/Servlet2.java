package by.bsac.pz1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=windows-1251";
	private int counter = 1;

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String count = request.getParameter("count");
		if (count != null && !count.isEmpty()) {
			try {
				counter = Integer.parseInt(count);
			} catch (NumberFormatException e) {

			}
		}
		out.println("<html>");
		out.println("<head><title>PZ 1</title></head>");
		out.println("<body>");
		out.println("<form method='GET'>");
		out.println("Текущее значение: " + counter + "<br>");
		out.println("<input type='hidden' name='count' value='" + (counter + 1) + "'>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}
}