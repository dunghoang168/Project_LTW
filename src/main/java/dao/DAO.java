/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;

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
    
    
    public List<Product> getProductBySellID(int id) {
    	List<Product> list = new ArrayList<>();
    	String query = "select * from product \n"
                + "where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
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
    public void delete(String pid) {
    	String query  = "delete from product \n"
    			+"where id = ?";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,pid);				
			ps.executeUpdate();
		} catch (Exception e) {		
		}
    
    }
    public void insertProduct(String name,String image, String price,String title,String description,String category,int sid) {
    	String query = "insert into product \n"
    			+ "VALUES (?,?,?,?,?,?,?)";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,image);
			ps.setString(3,price);
			ps.setString(4,title);
			ps.setString(5,description);
			ps.setString(6,category);
			ps.setInt(7,sid);
			ps.executeUpdate();
		} catch (Exception e) {		
		}
    }
    public void editProduct(String name,String image, String price,String title,String description,String category,String sid) {
    	String query = "update product\r\n"
    			+ "set [name] = ?,\r\n"
    			+ "[image] = ?,\r\n"
    			+ "price = ?,\r\n"
    			+ "[title] = ?,\r\n"
    			+ "[description] = ?,\r\n"
    			+ "[cateID] = ?\r\n"
    			+ "where id = ?";
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,image);
			ps.setString(3,price);
			ps.setString(4,title);
			ps.setString(5,description);
			ps.setString(6,category);
			ps.setString(7,sid);
			ps.executeUpdate();
		} catch (Exception e) {		
		}
    }
    
    

    public static void main(String[] args) {
        DAO dao = new DAO();
       // Account a = dao.login("aaa1","1");
      //  dao.signup("aaa1","1");
      //  System.out.println(dao.getCartProductByID("1"));
        
    }

}
