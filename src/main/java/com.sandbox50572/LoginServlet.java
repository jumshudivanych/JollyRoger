package com.sandbox50572;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    String adminLogin;//переменная для получения параметров инициализации по ключу из web.xml
    String adminPassword;

    //метод выполняется при создании сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminLogin = getInitParameter("adminLogin");
        adminPassword = getInitParameter("adminPassword");
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

        String username = null;
        String password = null;
        System.out.println("Enter doPost");

        request.setCharacterEncoding("UTF-8");
        String headers = request.getHeader(request.toString());//получение заголовка запроса
        username = request.getParameter("username");//получаем в переменную значение параметра
        password = request.getParameter("password");
        //ServletContext servletContext = getServletContext ();//получение ServletContext
        //servletContext.setAttribute("message", message);//добавление атрибута в ServletContext("name", value)
        System.out.println(headers);
        //Проверка на админ пароль
        if(username.equals(adminLogin) && password.equals(adminPassword)) {

            request.getRequestDispatcher("/admin.jsp").forward(request, response);//TODO изменить Uri админки на защищенный от случайного входа!!!
        }


        try {
            //инициализация драивера базы данных
            Class.forName("org.sqlite.JDBC");
            //создание подключения
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\idea\\sqlite\\login.db");//строка подключения
            //в строке подключения либо полный путь к фаилу либо
            //имя фаила если в тои же папке
            System.out.println("Connected");
            //создание sql запроса
            Statement stmt;
            stmt = connection.createStatement();
            /*
            //Запрос на добавление записи
            stmt.executeUpdate("INSERT INTO 'users' ('name', 'message') VALUES ('" + name + "', '" + message + "')");
            System.out.println("Запись добавлена");
            */
            //считывание из таблицы
            ResultSet resSet = stmt.executeQuery("SELECT id, login, pass FROM loginmap");
            while(resSet.next())
            {
                int id = resSet.getInt("id");
                String  login = resSet.getString("login");
                String  pass = resSet.getString("pass");

                if(username.equals(login) && password.equals(pass)) {
                    //переходить на страницу зарегистрированного пользователя
                    //передавать через Session attribute
                    request.getSession().setAttribute("username", login);
                    //request.setAttribute("username", login);
                    request.getRequestDispatcher("/simple.jsp").forward(request, response);
                }

            }

            resSet.close();
            stmt.close();
            connection.close();

            System.out.println("Соединения закрыты");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //возврат к регистрации
        //invalid login or password
        request.getRequestDispatcher("invalidLogin.jsp").forward(request, response);
    }

    }
