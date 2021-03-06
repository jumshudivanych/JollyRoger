package com.sandbox50572;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import java.util.Enumeration;

//import com.oreilly.servlet.RemoteDaemonHttpServlet;

/*
*<url-pattern>/send</url-pattern>
*/

public class SendServlet extends HttpServlet {



    String config1;//переменная для получения параметров инициализации по ключу из web.xml
    String config2;
    String message;

    //метод выполняется при создании сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        config1 = getInitParameter("key");
        config2 = getInitParameter("key2");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = "Session ID= " + request.getRequestedSessionId();
        //String message = null;
        String Uri = request.getRequestURI();//получение Uri
        //получение полей Http заголовка
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();//работа с заголовком

            if(headerName.equals("message")) {
                message = request.getHeader(headerName).toString();
            }
            //out.println("<TR><TD>" + headerName);
            //out.println("    <TD>" + request.getHeader(headerName));
        }

        //message = request.getParameter("message");

        try {
            //инициализация драивера базы данных
            Class.forName("org.sqlite.JDBC");
            //создание подключения
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\idea\\sqlite\\users.db");//строка подключения
            //в строке подключения либо полный путь к фаилу либо
            //имя фаила если в тои же папке
            System.out.println("Connected");
            //создание sql запроса
            Statement stmt;
            stmt = connection.createStatement();
            //Запрос на добавление записи
            stmt.executeUpdate("INSERT INTO 'users' ('name', 'message') VALUES ('" + name + "', '" + message + "')");
            System.out.println("Запись добавлена");
            stmt.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //Model model = Model.getInstance();//Вызов модели
        //message = model.getMessage();
        request.setAttribute("message", message);
        try {
            request.getRequestDispatcher("/simple.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String message = null;
        String name = null;
        System.out.println("Enter doPost");

        request.setCharacterEncoding("UTF-8");
        String headers = request.getHeader(request.toString());//получение заголовка запроса
        message = request.getParameter("message");//получаем в переменную значение параметра
        name = request.getParameter("param");
        ServletContext servletContext = getServletContext ();
        servletContext.setAttribute("message", message);
        System.out.println(headers);


        try {
            //инициализация драивера базы данных
            Class.forName("org.sqlite.JDBC");
            //создание подключения
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\idea\\sqlite\\users.db");//строка подключения
            //в строке подключения либо полный путь к фаилу либо
            //имя фаила если в тои же папке
            System.out.println("Connected");
            //создание sql запроса
            Statement stmt;
            stmt = connection.createStatement();
            //Запрос на добавление записи
            stmt.executeUpdate("INSERT INTO 'users' ('name', 'message') VALUES ('" + name + "', '" + message + "')");
            System.out.println("Запись добавлена");
            stmt.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/simple.jsp").forward(request, response);

    }
}