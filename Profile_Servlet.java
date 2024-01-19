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

@WebServlet("/profile")
public class Profile_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("Session1");
		
		if(email.equals("bhavna@gmail.com"))
		{
			HttpSession s1=req.getSession();
			s1.setAttribute("Session2", email);
			out.print("<h1> Welcome To Profile Page </h1>");
			out.print("<br>");
			out.print("<br>");
			out.print("<a href=detail> Go To Detail Page </a>");
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			
		}
	}

}

