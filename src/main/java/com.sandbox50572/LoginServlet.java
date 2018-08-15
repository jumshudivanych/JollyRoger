package com.sandbox50572;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    String config1;//переменная для получения параметров инициализации по ключу из web.xml
    String config2;

    //метод выполняется при создании сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        config1 = getInitParameter("key");
        config2 = getInitParameter("key2");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        //получить параметры логина, пароля сравнить с базой
        request.getRequestDispatcher("/simple.jsp").forward(request, response);
    }

    }
