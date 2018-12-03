package org.o7planning.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletOutputStream;

public class ServletOutput
{
	private ServletOutputStream output;
	
	public ServletOutput(ServletOutputStream output)
	{
		if (output == null)
			throw new IllegalArgumentException();
		
		this.output = output;
	}
	
	public void write(String line) throws IOException
	{
		output.println(line);
	}
	
	public void writeParameter(String name, String value) throws IOException
	{
		write("<br><span>" + name + ":</span>");
		write(value);
	}
}
