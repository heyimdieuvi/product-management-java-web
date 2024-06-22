/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.Account;
import model.Product;
import utilities.ConnectDB;

/**
 *
 * @author ADMIN
 */
    
    
public class ProductDAO  {

//    private ServletContext sc;
//    private static final String INSERT_PRODUCT = "INSERT INTO products (productId, productName, productImage, brief, postedDate, type, account, unit, price, discount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//    private static final String UPDATE_PRODUCT = "UPDATE products SET productName = ?, productImage = ?, brief = ?, postedDate = ?, type = ?, account = ?, unit = ?, price = ?, discount = ? WHERE productId = ?;";
//    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE productId = ?;";
//    private static final String GET_PRODUCT = "SELECT * FROM products WHERE productId = ?;";
//    private static final String GET_ALL_PRODUCTS = "SELECT * FROM products;";
//
//    @Override
//    public int insertRec(Product product) {
//        int result = 0;
//        try (Connection conn = new ConnectDB().getConnection();
//             PreparedStatement st = conn.prepareStatement(INSERT_PRODUCT)) {
//            st.setString(1, product.getProductId());
//            st.setString(2, product.getProductName());
//            st.setString(3, product.getProductImage());
//            st.setString(4, product.getBrief());
//            st.setDate(5, new java.sql.Date(product.getPostedDate().getTime()));
//            st.setString(6, product.getType().toString());
//            st.setString(7, product.getAccount().getAccount());
//            st.setString(8, product.getUnit());
//            st.setInt(9, product.getPrice());
//            st.setInt(10, product.getDiscount());
//
//            result = st.executeUpdate();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
//
//    @Override
//    public int updateRec(Product product) {
//        int result = 0;
//        try (Connection conn = new ConnectDB().getConnection();
//             PreparedStatement st = conn.prepareStatement(UPDATE_PRODUCT)) {
//            st.setString(1, product.getProductName());
//            st.setString(2, product.getProductImage());
//            st.setString(3, product.getBrief());
//            st.setDate(4, new java.sql.Date(product.getPostedDate().getTime()));
//            st.setString(5, product.getType().toString());
//            st.setString(6, product.getAccount().getAccount());
//            st.setString(7, product.getUnit());
//            st.setInt(8, product.getPrice());
//            st.setInt(9, product.getDiscount());
//            st.setString(10, product.getProductId());
//
//            result = st.executeUpdate();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
//
//    @Override
//    public int deleteRec(String productId) {
//        int result = 0;
//        try (Connection conn = new ConnectDB().getConnection();
//             PreparedStatement st = conn.prepareStatement(DELETE_PRODUCT)) {
//            st.setString(1, productId);
//            result = st.executeUpdate();
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
//
//    @Override
//    public Product getObjectById(String productId) {
//        Product product = null;
//        try (Connection conn = new ConnectDB().getConnection();
//             PreparedStatement st = conn.prepareStatement(GET_PRODUCT)) {
//            st.setString(1, productId);
//            ResultSet res = st.executeQuery();
//            if (res.next()) {
//                String productName = res.getString("productName");
//                String productImage = res.getString("productImage");
//                String brief = res.getString("brief");
//                Date postedDate = res.getDate("postedDate");
//                //Category type = Category.valueOf(res.getString("type"));
//                Account account = new AccountDAO().getObjectById(res.getString("account"));
//                String unit = res.getString("unit");
//                int price = res.getInt("price");
//                int discount = res.getInt("discount");
//
//                product = new Product(productId, productName, productImage, brief, postedDate, type, account, unit, price, discount);
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return product;
//    }
//
//    @Override
//    public List<Product> listAll() {
//        List<Product> productList = new ArrayList<>();
//        try (Connection conn = new ConnectDB().getConnection();
//             PreparedStatement st = conn.prepareStatement(GET_ALL_PRODUCTS)) {
//            ResultSet res = st.executeQuery();
//            while (res.next()) {
//                String productId = res.getString("productId");
//                String productName = res.getString("productName");
//                String productImage = res.getString("productImage");
//                String brief = res.getString("brief");
//                Date postedDate = res.getDate("postedDate");
//                //Category type = Category.valueOf(res.getString("type"));
//                Account account = new AccountDAO().getObjectById(res.getString("account"));
//                String unit = res.getString("unit");
//                int price = res.getInt("price");
//                int discount = res.getInt("discount");
//
//                Product product = new Product(productId, productName, productImage, brief, postedDate, type, account, unit, price, discount);
//                productList.add(product);
//            }
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return productList;
//    }
}