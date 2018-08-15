<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>

<link href="resources/logo.css" rel="stylesheet">
<style type="text/css">

</style>
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

<div name=chat>
    "message": <%= request.getParameter("message")%>
    <form action="send" method="post">
     <p><input placeholder="Welcome!" name="message" scope="request">
     <p><input type="submit" value="Send"></p>
    </form>
</div>
<p>Message: <%
                 ServletContext sc = request.getServletContext();
                 out.println(sc.getAttribute("message"));
            %>

<script>

</script>
<div name=update>
    <form action="getMessage" method="post">
    <p><input type="submit" value="getMessage"></p>
    </form>
</div>
</body>
</html>
