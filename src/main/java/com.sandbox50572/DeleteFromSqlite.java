package com.sandbox50572;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteFromSqlite extends HttpServlet {

    String adminlogin;
    String adminpassword;

    //метод выполняется при создании сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminlogin = getInitParameter("adminLogin");
        adminpassword = getInitParameter("adminPassword");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


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
            stmt.executeUpdate("DELETE FROM 'users'");
            System.out.println("таблица очищена");
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
