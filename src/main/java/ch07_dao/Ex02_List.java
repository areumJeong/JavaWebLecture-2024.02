package ch07_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.tomcat.jakartaee.bcel.classfile.Code;

@WebServlet("/ch07/city/list")
public class Ex02_List extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String code = request.getParameter("code");
      
      code = (code == null || code.equals("")) ? "KOR" : code; 
      
      String num_ = request.getParameter("num");
      int num = ( num_ == null || num_.equals("")) ? 10 : Integer.parseInt(num_);
      
      String offset_ = request.getParameter("offset ");
      int offset  = ( offset_  == null ||offset_.equals("")) ? 10 : Integer.parseInt(offset_ );
      
      CityDao cDao = new CityDao();
      List<City> list = cDao.getCityList(code, num, offset);
      list.forEach(x -> System.out.println(x));

      RequestDispatcher rd = request.getRequestDispatcher("/ch07/list.jsp");
      request.setAttribute("list", list);
      rd.forward(request, response); //
   }

}