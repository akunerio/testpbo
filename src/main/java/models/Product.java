/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import utils.JDBC;

/**
 *
 * @author luliou
 */
public class Product extends JDBC {

    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Product toModel(ResultSet rs) {
        try {
            return new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price")
            );
        } catch (Exception e) {
            setMessage(e.getMessage());
        }

        return null;
    }

    private String setMessage(String message) {
        return "Error";
    }

    public ArrayList<Product> get() {
        ArrayList<Product> res = new ArrayList<>();
        try {
            ResultSet rs = getData("select * from product");
            while (rs.next()) {
                res.add(toModel(rs));
            }

        } catch (Exception e) {
            setMessage(e.getMessage());
        }
        return res;
    }

    ArrayList<Object> toRow(ResultSet rs) {
        ArrayList<Object> res = new ArrayList<>();
        int i = 1;
        try {
            while (true) {
                res.add(rs.getObject(i));
                i++;
            }

        } catch (Exception e) {
        }
        return res;
    }

    public ArrayList<ArrayList<Object>> query(String query) {
        ArrayList<ArrayList<Object>> res = new ArrayList<>();
        try {
            ResultSet rs = getData(query);
            while (rs.next()) {
                res.add(toRow(rs));
            }
            
        } catch (Exception e) {
            setMessage(e.getMessage());
        }
        return res;
    }
    

}
