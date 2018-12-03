package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showMe")
public class ShowMeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ServletOutputStream out = resp.getOutputStream();
		
		Enumeration<String> attributes = req.getAttributeNames();
		while (attributes.hasMoreElements())
		{
			String attributeName = attributes.nextElement();
			
			out.println(attributeName + ": " + req.getAttribute(attributeName));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
