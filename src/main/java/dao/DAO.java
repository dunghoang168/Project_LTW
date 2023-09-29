/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getProductByCID(String cateID) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product \n"
        		+"where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,cateID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getProductByID(String id) {
        String query = "select * from product \n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getProductBySearch(String textSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product \n"
        		+"where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+textSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Account login(String user , String pass) {
    	String query  = "select * from Account \n"
    			+"where [user] = ? \n"
    			+"and pass = ?";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);
			rs = ps.executeQuery();
    		while (rs.next()) {
    		return  new Account(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5));	
    			
    		}
		} catch (Exception e) {		
		}
    	
    	return null;
    
    }
    
    public void signup(String user , String pass) {
    	String query  = "insert into Account \n"
    			+" values (?,?,0,0)";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,user);
			ps.setString(2,pass);	
			ps.executeUpdate();
		} catch (Exception e) {		
		}
    
    }
    
    public Account checkAccountExist(String user) {
    	String query  = "select * from Account \n"
    			+"where [user] = ? \n";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,user);
			rs = ps.executeQuery();
			while (rs.next()) {
	    		return  new Account(rs.getInt(1),
	                    rs.getString(2),
	                    rs.getString(3),
	                    rs.getInt(4),
	                    rs.getInt(5));	    			
	    		}
		} catch (Exception e) {		
		}
    return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Account a = dao.login("aaa1","1");
      //  dao.signup("aaa1","1");
        System.out.println(a);
        
    }

}
