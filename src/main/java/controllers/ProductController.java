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

        String menu = request.getParameter("action");
        if (menu == null) { //view menu
            //get all data from database

            request.setAttribute("title", "Daftar Produk");
            ArrayList<Product> prods = new ArrayList<>();
            prods.add(new Product(1, "Nasi Goreng", 15000));
            prods.add(new Product(2, "Nasi Mawud", 20000));
            request.setAttribute("list", prods);

            request.getRequestDispatcher("view_product.jsp").forward(request, response);
        } else if ("add".equals(menu)) {
            request.getRequestDispatcher("form_product.jsp").forward(request, response);
        
        } else if ("edit".equals(menu)) {
            //get one data from database

            request.setAttribute("title", "Edit Produk");
            Product p = new Product(2, "Nasi Goreng", 15000);
            request.setAttribute("product", p);
            request.getRequestDispatcher("form_product.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
