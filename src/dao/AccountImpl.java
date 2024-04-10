package dao;

import configs.connectDB;
import models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements AccountDao{
    Connection conn;

    @Override
    public List<Account> getAccounts() {
        conn = connectDB.openConnection();
        List<Account> data = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from account");
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString("accountId"));
                account.setCustomerName(rs.getString("customerName"));
                account.setCreateDate(rs.getDate("createDate"));
                account.setPhone(rs.getString("phone"));
                account.setAddress(rs.getString("address"));
                account.setBalance(rs.getFloat("balance"));
                account.setActive(rs.getInt("active"));
                data.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn);
        }
        return data;
    }

    @Override
    public Account getById(String id) {
        conn = connectDB.openConnection();
        Account account = new Account();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from account where accountId = ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                account.setAccountId(rs.getString("accountId"));
                account.setCustomerName(rs.getString("customerName"));
                account.setCreateDate(rs.getDate("createDate"));
                account.setPhone(rs.getString("phone"));
                account.setAddress(rs.getString("address"));
                account.setBalance(rs.getFloat("balance"));
                account.setActive(rs.getInt("active"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn);
        }
        return account;
    }

    @Override
    public boolean insert(Account acc) {
        boolean result = false;
        conn = connectDB.openConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("insert into account values(?,?,?,?,?,?,?)");
            pst.setString(1, acc.getAccountId());
            pst.setString(2, acc.getCustomerName());
            pst.setDate(3, acc.getCreateDate());
            pst.setString(4, acc.getPhone());
            pst.setString(5, acc.getAddress());
            pst.setFloat(6, acc.getBalance());
            pst.setInt(7, acc.getActive());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn);
        }
        return result;
    }

    @Override
    public boolean update(Account acc) {
        boolean result = false;
        conn = connectDB.openConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("update account set customerName = ?, createDate = ?, phone = ?, address = ?, balance = ?, active = ? where accountId = ?");
            pst.setString(7, acc.getAccountId());
            pst.setString(1, acc.getCustomerName());
            pst.setDate(2, acc.getCreateDate());
            pst.setString(3, acc.getPhone());
            pst.setString(4, acc.getAddress());
            pst.setFloat(5, acc.getBalance());
            pst.setInt(6, acc.getActive());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn);
        }
        return result;
    }

    @Override
    public List<Account> search(float from, float to) {
        conn = connectDB.openConnection();
        List<Account> data = new ArrayList<>();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from account where balance in (?, ?)");
            pst.setFloat(1, from);
            pst.setFloat(1, to);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString("accountId"));
                account.setCustomerName(rs.getString("customerName"));
                account.setCreateDate(rs.getDate("createDate"));
                account.setPhone(rs.getString("phone"));
                account.setAddress(rs.getString("address"));
                account.setBalance(rs.getFloat("balance"));
                account.setActive(rs.getInt("active"));
                data.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn);
        }
        return data;
    }
}
