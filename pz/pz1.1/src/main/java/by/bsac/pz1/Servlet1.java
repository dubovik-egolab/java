package by.bsac.pz1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=windows-1251";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		String p1Value = request.getParameter("P1");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>PZ 1</title></head>");
		out.println("<body>");
		out.println("<form>");
		out.println("Поле для ввода: <input type='text' name='P1' value='" + (p1Value != null ? p1Value : "") + "'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
	
		if (p1Value != null && !p1Value.isEmpty()) {
			out.println("<p>Введенное значение (повторено дважды): " + p1Value + " "  + p1Value + "</p>");
        }
		
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}
}
