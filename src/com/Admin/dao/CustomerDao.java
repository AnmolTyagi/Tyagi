package com.Admin.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import com.Admin.bean.Customer;
public class CustomerDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int save(Customer u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into register(fname,lname,age,gender,id) values(?,?,?,?,?)");
		ps.setString(1,u.getFname());
		ps.setString(2,u.getLname());
		ps.setInt(3,u.getAge());
		ps.setString(4,u.getGender());
		ps.setInt(5,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
	
	 Cookie cookie=new Cookie("user","logincookie");
	 res.addCookie(cookie);
}
public static int update(Customer u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update register set fname=?,lname=?,age=?,gender=?, where id=?");
		ps.setString(1,u.getFname());
		ps.setString(2,u.getLname());
		ps.setInt(3,u.getAge());
		ps.setString(4,u.getGender());
		ps.setInt(5,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;	
}

public static int delete(Customer u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from register where id=?");
		ps.setInt(1,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public static List<Customer> getAllRecords(){
	List<Customer> list=new ArrayList<Customer>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from register");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Customer u=new Customer();
			u.setId(rs.getInt("id"));
			u.setFname(rs.getString("fname"));
			u.setLname(rs.getString("lname"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
		
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static Customer getRecordById(int id){
	Customer u=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from register where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new Customer();
			u.setId(rs.getInt("id"));
			u.setFname(rs.getString("fname"));
			u.setLname(rs.getString("lname"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}
}
