/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author pc
 */
public class UserDao {
    
    public void insert(User x){
        
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            st.executeUpdate("insert into users (name,email,password) values ('"+x.getName()+"','"+x.getEmail()+"','"+x.getPassword()+"')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void insert2(User y){
        
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            st.executeUpdate("insert into delivery (startdate,enddate,a,b) values ('"+y.getStartdate()+"','"+y.getEnddate()+"','"+y.getA()+"','"+y.getB()+"')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> read(){
        List <User> list=new ArrayList<>();
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from shippingnumbers ");
            while(rs.next()){
                User tmp=new User(rs.getString("numbers"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<User> read2(){
        List <User> list=new ArrayList<>();
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from fees ");
            while(rs.next()){
                User tmp=new User(rs.getInt("fee"));
                list.add(tmp);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
  
    public List<User> read3(){
        List <User> list=new ArrayList<>();
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from vehicleplates ");
            while(rs.next()){
                User tmp=new User(rs.getString("plates"),rs.getString("model"));
                list.add(tmp);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
   
}
