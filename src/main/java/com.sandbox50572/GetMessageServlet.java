package com.sandbox50572;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//<url-pattern>/getMessage</url-pattern>

public class GetMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            request.getRequestDispatcher("/simple.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Object message = null;
        System.out.println("Enter doPost");

        request.setCharacterEncoding("UTF-8");
        //message = request.getParameter("message");//получаем в переменную значение параметра
        //Model model = Model.getInstance();//Вызов модели
        //message = model.toString();
        //ServletContext servletContext = getServletContext ();
        //servletContext.setAttribute("message", message);

        request.getRequestDispatcher("/simple.jsp").forward(request, response);
    }
}
