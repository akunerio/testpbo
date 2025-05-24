/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Product;

/**
 *
 * @author luliou
 */
@WebServlet(name = "Product", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");

        if (request.getParameterMap().isEmpty()) { //view menu
            //get all data from database

            request.setAttribute("title", "Daftar Produk");

            ArrayList<Product> prods = new Product().get();

            request.setAttribute("list", prods);

            request.getRequestDispatcher("view_product.jsp").forward(request, response);

        } else if ("add".equals(menu)) {
            request.setAttribute("title", "Tambah Produk");
            request.getRequestDispatcher("form_product_2.jsp").forward(request, response);

        } else if ("edit".equals(menu)) {
            //get one data from database

            request.setAttribute("title", "Edit Produk");
            request.setAttribute("action", "?id=" + request.getParameter("id"));
            Product p = new Product().find(request.getParameter("id"));
            if (p == null) {
                response.sendRedirect("product");
                return;
            }
            request.setAttribute("product", p);
            request.getRequestDispatcher("form_product_2.jsp").forward(request, response);

        } else if ("custom".equals(menu)) {

            request.setAttribute("title", "Dashboard");

            ArrayList<ArrayList<Object>> prods = new Product().query("SELECT COUNT(*), AVG(price) FROM product");
            request.setAttribute("list", prods);

            request.getRequestDispatcher("view_custom.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String id = request.getParameter("id");

        if (id == null) { //insert data
            Product p = new Product();
            p.setName(request.getParameter("name"));
            p.setPrice(Double.parseDouble(request.getParameter("price")));
            p.insert();
        } else if(action == null && id != null) {
            Product p = new Product();
            p.setId(Integer.parseInt(id));
            p.setName(request.getParameter("name"));
            p.setPrice(Double.parseDouble(request.getParameter("price")));
            p.update();
        } else if("del".equals(action)) {
            Product p = new Product().find(id);
            System.out.print(p.getName());
            if(p != null){
                p.delete();
            }
        }
        
        response.sendRedirect("product");
    }

}
