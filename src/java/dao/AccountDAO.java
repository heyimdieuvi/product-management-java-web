/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class AccountDAO implements Accessible<Account>{
    private ServletContext sc;
    private static final String INSERT_ACCOUNT = "INSERT INTO [dbo].[accounts] (account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) VALUES" + "(?,?,?,?,?,?,?,?,?);";

    
    @Override
    public int insertRec(Account acc) {
        int result = 0;
        try(Connection conn = new ConnectDB().getConnection();
                PreparedStatement st = conn.prepareStatement(INSERT_ACCOUNT)) {
            st.setString(1, acc.getAccount());
            st.setString(2, acc.getPass());
            st.setString(3, acc.getLastName());
            st.setString(4, acc.getFirstName());
            st.setDate(5, acc.getBirthday());
            st.setBoolean(6, acc.isGender());
            result = st.executeUpdate();
                
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Account> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
