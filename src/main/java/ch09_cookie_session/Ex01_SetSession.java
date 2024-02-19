package ch09_cookie_session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ch09/setSession")
public class Ex01_SetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("price", 12500);
		session.setAttribute("uid", "james");
		String[] fruits = {"apple", "banana", "cherry"};
		session.setAttribute("fruits", fruits);
		
		session.setMaxInactiveInterval(24 * 60 * 60);		// 24시간
	}
}