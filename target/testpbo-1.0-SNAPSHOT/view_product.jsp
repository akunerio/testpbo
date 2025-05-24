<%-- 
    Document   : view_product
    Created on : May 10, 2025, 11:38:24 AM
    Author     : luliou
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@page import="java.util.ArrayList, models.Product" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h3>${title}</h3>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Nama</th>
                <th>Harga</th>
                <th colspan="2">Aksi</th>
            </tr>
            <%
            ArrayList<Product> prods = (ArrayList<Product>) request.getAttribute("list");
            int i = 1;
            for (Product p: prods) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getPrice() %></td>
                <td><a href="?menu=edit&id=<%= p.getId() %>">Edit</a></td>
                <td>
                    <form method="POST" action="product?action=del&id=<%= p.getId() %>">
                        <button>Hapus</button>
                    </form>
                    
                </td>
            </tr>
            <% } %>
        </table>
    </body>
</html>