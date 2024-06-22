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
import utilities.ConnectDB;

/**
 *
 * @author ADMIN
 */
public class AccountDAO implements Accessible<Account> {

    private ServletContext sc;
    private static final String INSERT_ACCOUNT = "INSERT INTO [dbo].[accounts] (account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) VALUES" + "(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_ACCOUNT = "UPDATE accounts SET pass = ?,lastName = ?, firstName = ?, birthday = ?, gender = ?, phone = ?, isUse = ?, roleInSystem = ? where account = ?;";
    private static final String DELETE_ACCOUNT = "DELETE accounts WHERE account = ?;";
    private static final String GET_ACCOUNT = "SELECT * FROM accounts WHERE account = ?;";
    private static final String GET_ALL_ACCOUNT = "SELECT * FROM accounts;";
    private static final String GET_EXIST_ACCOUNT = "SELECT * FROM accounts WHERE account = ? and pass = ?;";

    @Override
    public int insertRec(Account acc) {
        int result = 0;
        try ( Connection conn = new ConnectDB().getConnection();  PreparedStatement st = conn.prepareStatement(INSERT_ACCOUNT)) {
            st.setString(1, acc.getAccount());
            st.setString(2, acc.getPass());
            st.setString(3, acc.getLastName());
            st.setString(4, acc.getFirstName());
            st.setDate(5, acc.getBirthday());
            st.setBoolean(6, acc.isGender());
            st.setString(7, acc.getPhone());
            st.setBoolean(8, acc.isIsUse());
            st.setInt(9, acc.getRoleInSystem());
            
            result = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateRec(Account acc) {
        int result = 0;
        try ( Connection conn = new ConnectDB().getConnection();  
                PreparedStatement st = conn.prepareStatement(UPDATE_ACCOUNT)) {
            st.setString(1, acc.getAccount());
            st.setString(2, acc.getPass());
            st.setString(3, acc.getLastName());
            st.setString(4, acc.getFirstName());
            st.setDate(5, acc.getBirthday());
            st.setBoolean(6, acc.isGender());
            st.setString(7, acc.getPhone());
            st.setBoolean(8, acc.isIsUse());
            st.setInt(9, acc.getRoleInSystem());
            result = st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int deleteRec(String id) {
        int res = 0;
        try ( Connection conn = new ConnectDB().getConnection();  
                PreparedStatement st = conn.prepareStatement(DELETE_ACCOUNT)) {
            st.setString(1, id);
            res = st.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return res;
    }

    @Override
    public Account getObjectById(String acc) {
        Account currentAcc = null;
        try ( Connection conn = new ConnectDB().getConnection();  
                PreparedStatement st = conn.prepareStatement(GET_ACCOUNT)) {
            st.setString(1, acc);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                String account = res.getString("account");
                String pass = res.getString("pass");
                String lastName = res.getString("lastName");
                String firstName = res.getString("firstName");
                Date birthday = res.getDate("birthday");
                boolean gender = res.getBoolean("gender");
                String phone = res.getString("phone");
                boolean isUse = res.getBoolean("isUse");
                int roleInSystem = res.getInt("roleInSystem");
                
                currentAcc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return currentAcc;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList();
        try ( Connection conn = new ConnectDB().getConnection();  
                PreparedStatement st = conn.prepareStatement(GET_ALL_ACCOUNT)) {
            ResultSet res = st.executeQuery();
            while (res.next()) {
                String account = res.getString("account");
                String pass = res.getString("pass");
                String lastName = res.getString("lastName");
                String firstName = res.getString("firstName");
                Date birthday = res.getDate("birthday");
                boolean gender = res.getBoolean("gender");
                String phone = res.getString("phone");
                boolean isUse = res.getBoolean("isUse");
                int roleInSystem = res.getInt("roleInSystem");
                
                list.add(new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return list;
    }

    public Account getExistAccount(String acc, String password) {
        Account currentAcc = null;
        try ( Connection conn = new ConnectDB().getConnection();  
                PreparedStatement st = conn.prepareStatement(GET_EXIST_ACCOUNT)) {
            st.setString(1, acc);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                String account = res.getString("account");
                String pass = res.getString("pass");
                String lastName = res.getString("lastName");
                String firstName = res.getString("firstName");
                Date birthday = res.getDate("birthday");
                boolean gender = res.getBoolean("gender");
                String phone = res.getString("phone");
                boolean isUse = res.getBoolean("isUse");
                int roleInSystem = res.getInt("roleInSystem");
                
                currentAcc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return currentAcc;
    }

}
