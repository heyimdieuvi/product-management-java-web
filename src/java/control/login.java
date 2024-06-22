/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import dao.AccountDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Login extends HttpServlet {

    private AccountDAO accountDao = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String desPage;
        String message;
        String acc = request.getParameter("account");
        String pass = request.getParameter("password");
        try {
            desPage = "login.jsp";
            //kiem tra xem user co ton tai khong
            if (acc.isEmpty() || pass.isEmpty()) {
                message = "Invalid input";
                request.setAttribute("message", message);
            } else {
                Account account = accountDao.getExistAccount(acc, pass);
                if (account != null) {
                    //if Login success -> set attribute in session to store info of user
                    HttpSession session = request.getSession();
                    session.setAttribute("account", account);
                    desPage = "dash-board.jsp";
                } else {
                    message = "Wrong email or password!!!";
                    //send message to Login page and Login again
                    request.setAttribute("message", message);
                }
            }
            request.getRequestDispatcher(desPage).forward(request, response);
        } catch (ServletException e) {
            e.getMessage();
        }
    }

}
