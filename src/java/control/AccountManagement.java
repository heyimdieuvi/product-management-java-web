/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountManagement extends HttpServlet {
    private AccountDAO accDao = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
    
    private void showListAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Account> listUser = accDao.listAll();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("account-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("account-form.jsp").forward(request, response);
    }
 
    //this will send user's info when editing
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String accName = request.getParameter("account");
        Account acc = accDao.getObjectById(accName);
        request.setAttribute("user", acc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acccount-form.jsp");
        dispatcher.forward(request, response);
    }

    //If insert a exist id -> ???
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
//        Account newUser = new Account(name, email, country);
//        userDAO.insertUser(newUser);
        response.sendRedirect("abv");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String id = request.getParameter("id");
        accDao.deleteRec(id);
        response.sendRedirect(request.getContextPath()+"/home");
    }

    //edit user info
    //**If edited id is exist?? What happend??
    //No permission to update id -> How to?
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //get request data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
//        User user = new User(id, name, email, country);
//        userDAO.updateUser(user);
        response.sendRedirect("list");
    }



}
