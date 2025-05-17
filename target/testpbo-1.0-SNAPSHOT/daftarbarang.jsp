<%-- 
    Document   : daftarbarang
    Created on : May 17, 2025, 11:39:49 AM
    Author     : luliou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Nama</td>
            </tr>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("list");
                if (rs != null) {
                    while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rs.getInt("id") + "</td>");
                        out.print("<td>" + rs.getString("name") + "</td>");
                        out.print("</tr>");
                    }
                }
            %>
        </table>
    </body>
</html>
