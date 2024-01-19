package servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Login")
public class Password_Filter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String pswd=request.getParameter("pswd");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		if(pswd.length()>=8)
		{
			boolean sm_case=false;
			boolean up_case=false;
			boolean num=false;
			boolean sp_char=false;
			
			for(int i=0;i<pswd.length();i++)
			{
				char ch=pswd.charAt(i);
				int var=(int)ch;
				if(var>=97 && var<=122)
				{
					sm_case=true;
				}
				else if(var>=65 && var<=90)
				{
					up_case=true;
				}
				else if(var>=48 && var<=57)
				{
					num=true;
				}
				else if(var==35 || var==36 || var==64)
				{
					sp_char=true;
				}
			}
			if(sm_case==true && up_case==true && num==true && sp_char==true)
			{
				chain.doFilter(request, response);
			}
			else
			{
				out.print("<h4>Password Validation Fail..</h4>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			
		}
		else
		{
			out.print("<h4>Password Length Is Less Than 8</h4>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
		
		
	}

}
