/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

public class Home extends HttpServlet {

    private CategoryDAO categoryDao = new CategoryDAO();
    private ProductDAO productDao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve list of categories
        List<Category> listCategories = categoryDao.listAll();
        request.setAttribute("listCategories", listCategories);

        // Retrieve list of products
        List<Product> listProducts = productDao.listAll();
        request.setAttribute("listProducts", listProducts);

        // Retrieve the last product (assuming the last product is the most recent one)
        if (!listProducts.isEmpty()) {
            Product lastProduct = listProducts.get(listProducts.size() - 1);
            request.setAttribute("lastProduct", lastProduct);
        }

        // Forward to home.jsp
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
