<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<link href="resources/logo.css" rel="stylesheet">
<link href="resources/login_form.css" rel="stylesheet">
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
        <li><a href="/JollyRoger">Главная</a></li>
        <li><a href="/send">Войти</a></li>
      </ul>
    </nav>
  </div>
</header>

<div id="login_form">
    <form name="f1" method="post" action="login" id="f1">
        <table>
            <tr>
                <td class="f1_label">User Name :</td><td><input type="text" name="username" value="" />
                </td>
            </tr>
            <tr>
                <td class="f1_label">Password  :</td><td><input type="password" name="password" value=""  />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="login" value="Log In" style="font-size:18px; " />
                </td>
            </tr>
        </table>
    </form>
</div>

<div bgcolor="#FFFFFF">

</div>


</body>
</html>
