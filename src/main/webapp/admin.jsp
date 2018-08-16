<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
<link href="resources/logo.css" rel="stylesheet">
<!-- Подключаем библиотеку -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body bgcolor="#E0FFFF">

<header>
  <div class="container">
    <a href="/JollyRoger" class="logo"><img src="resources/images/logo1.png"></a>
    <H2>Jolly Roger</H2>
    <nav>
      <ul>
        <li><a href="/JollyRoger">Welcome</a></li>
        <li><a href="login">Login</a></li>
      </ul>
    </nav>
  </div>
</header>
<p>
<%
   // обновляет страницу каждыу 60 секунд
   response.setIntHeader("Refresh", 60);
   // 获取当前时间
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("" + CT + "\n");
%>
<h2>Welcome jumshudivanych</h2>
<div id="contact_form">
Message in ServletContext: <%
            ServletContext sc = request.getServletContext();
            out.println(sc.getAttribute("message"));
         %>
 </div>

<script>

</script>
<p>Message in sqlite: <%
                         try {
                                     Statement stmt;
                                     //инициализация драивера базы данных
                                     Class.forName("org.sqlite.JDBC");
                                     //создание подключения
                                     Connection connection = DriverManager.getConnection(
                                             "jdbc:sqlite:C:\\idea\\sqlite\\login.db");//строка подключения
                                     //в строке подключения либо полный путь к фаилу либо
                                     //имя фаила если в тои же папке
                                     System.out.println("Connected from jsp");
                                     //создание sql запроса
                                     stmt = connection.createStatement();
                                     //считывание из таблицы
                                                 ResultSet resSet = stmt.executeQuery("SELECT id, login, pass FROM loginmap");
                                                 while(resSet.next())
                                                 {
                                                     int id = resSet.getInt("id");
                                                     String  login = resSet.getString("login");
                                                     String  password = resSet.getString("pass");

                                                     out.println("ID = " + id);
                                                     out.println("login = " + login);
                                                     out.println("password = " + password);

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
                      %>

<div id="message" name="chat">

    <form action="admin" method="post">
     <p><input placeholder="Admin" name="message">
     <p><input type="submit" value="Send"></p>
    </form>

</div>
<div name=update>
    <form action="getMessage" method="post">
        <p><input type="submit"  id="a" class="button" value="getMessage"></p>
        </form>
</div>
</body>
</html>