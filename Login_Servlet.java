package servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login_Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet Executed.......");
		String email=req.getParameter("email");
		String pswd=req.getParameter("pswd");
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		Connection con=Data_Base_Connection.db_con();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from User");
			while(rs.next())
			{
				if(email.equals(rs.getString(1)) && pswd.equals(rs.getString(2)))
				{
					HttpSession session=req.getSession();
					session.setAttribute("Session1", email);
					RequestDispatcher rd=req.getRequestDispatcher("profile");
					rd.forward(req, resp);
					break;
				}
				else
				{
					out.print("<h4>Invalid Email or Password </h4>");
					RequestDispatcher rd=req.getRequestDispatcher("index.html");
					rd.include(req, resp);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

