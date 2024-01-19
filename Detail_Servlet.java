package servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/detail")
public class Detail_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("Session2");
		if(email.equals("bhavna@gmail.com"))
		{
			out.print("<h1> Welcome To Detail Page...</h1>");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
		}
		
	}

}

