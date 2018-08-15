package com.sandbox50572;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/*
*<url-pattern>/toSqlite</url-pattern>
*/

public class AccessSqlite extends HttpServlet {

    Statement stmt;

    //метод выполняется при создании сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
            stmt = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }
    */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String message = null;
        String message2 = null;
        System.out.println("Enter doPost");

        request.setCharacterEncoding("UTF-8");

        message = request.getParameter("message");//получаем в переменную значение параметра

        //создание sql запроса добавление записи

        try {
            stmt.execute("INSERT INTO 'users' ('name', 'message') VALUES ('ivan', '" + message + "');");//TODO тут sql запрос
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Запись добавлена");

        //считывание последней записи из БД
        try {
           message2 = String.valueOf(stmt.execute("SELECT * FROM users;\n"));//тут sql запрос
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Считывание из базы");
        //перенаправление на страницу /simple.jsp
        request.setAttribute("message", message2);
        request.getRequestDispatcher("/simple.jsp").forward(request, response);

    }
}
