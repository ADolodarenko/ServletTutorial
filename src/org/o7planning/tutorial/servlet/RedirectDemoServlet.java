package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the value of parameter on the URL.
        String redirect = req.getParameter("redirect");
 
        if ("true".equals(redirect)) {
            System.out.println("Redirect to ShowMeServlet");
 
            // contextPath: Is an empty string "" or non-empty.
            // If it is non-empty, it always starts with /
            // and does not ends with /
            String contextPath = req.getContextPath();
 
            // ==> /ServletTutorial/showMe
            resp.sendRedirect(contextPath + "/showMe");
            
            return;
        }
 
        ServletOutputStream out = resp.getOutputStream();
        out.println("<html><body>");
        out.println("<h3>Text of RedirectDemoServlet</h3>");
        out.println("- servletPath=" + req.getServletPath());
        out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
