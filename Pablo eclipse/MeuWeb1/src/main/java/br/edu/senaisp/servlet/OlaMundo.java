package br.edu.senaisp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/olamundo")
public class OlaMundo extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter html = resp.getWriter();
	
		
	html.println("<html>");
	html.println("<body>");
	html.println("<h1>ola mundo </h1>");
	html.println("</body>");
	html.println("</html>");
	}

}
