package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/exampleInfo")
public class ExampleInfoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public ExampleInfoServlet()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ServletOutput out = new ServletOutput(resp.getOutputStream());
		
		out.write("<style> span {color:blue;} </style>");
	     
	    out.writeParameter("requestURL", req.getRequestURL().toString());
	    out.writeParameter("requestURI", req.getRequestURI());
	    out.writeParameter("contextPath", req.getContextPath());
	    out.writeParameter("servletPath", req.getServletPath());
	    out.writeParameter("queryString", req.getQueryString());
	    out.writeParameter("text1", req.getParameter("text1"));
	    out.writeParameter("text2", req.getParameter("text2"));
	     
	    out.write("<br><br><b>Server info:</b>");
	    
	    out.writeParameter("serverName", req.getServerName());
        out.writeParameter("serverPort", req.getServerPort() + "");
 
        out.write("<br><br><b>Client info:</b>");
 
        out.writeParameter("remoteAddr", req.getRemoteAddr());
        out.writeParameter("remoteHost", req.getRemoteHost());
        out.writeParameter("remotePort", req.getRemotePort() + "");
        out.writeParameter("remoteUser", req.getRemoteUser());

        out.write("<br><br><b>headers:</b>");
 
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements())
        {
            String header = headers.nextElement();
            out.write("<br><span>" + header + "</span>: " + req.getHeader(header));
        }
 
        out.write("<br><br><b>Servlet Context info:</b>");
        ServletContext servletContext = req.getServletContext();
 
        out.writeParameter("realPath", servletContext.getRealPath(""));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}
	
	

}
