<%-- 
    Document   : form_search
    Created on : May 10, 2025, 11:03:25 AM
    Author     : luliou
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>Search Page</title>
    </head>
    <body>
        <h1>Hello, user</h1>
        <a href="auth?logout"><button>Logout</button></a> <br /><br />
        <form method="get" action="home">
            Keyword : <input type="text" name="key" /><br /> <input type="submit" value="Search" />
        </form>
        ${hasil}
    </body>
</html>