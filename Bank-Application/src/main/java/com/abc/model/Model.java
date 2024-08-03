package com.abc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	
	private String name;
	private String Custid;
	private int accno;
	private String pwd;
	private int bal;
	private String email;
	private int raccno;
	private Connection con;
	private PreparedStatement pstm;
	public ArrayList al = new ArrayList();
	public ArrayList sal = new ArrayList();
	public ArrayList ral = new ArrayList();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustid() {
		return Custid;
	}
	public void setCustid(String custid) {
		Custid = custid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRaccno() {
		return raccno;
	}
	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}
	
	public Model() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");		//loading the driver
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplication", "root", "root");		//registering the driver
	}
	public boolean register() throws SQLException {
		String sql = "insert into ABCBank values(?,?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, Custid);
		pstm.setInt(3, accno);
		pstm.setString(4, pwd);
		pstm.setInt(5, bal);
		pstm.setString(6, email);
		
		int x = pstm.executeUpdate();
		
		if(x>0) {
			return true;
		}
		
		return false;
	}
	public boolean login() throws SQLException {
		String sql = "select * from ABCBank where custid=? and password=?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, Custid);
		pstm.setString(2, pwd);
		
		ResultSet res = pstm.executeQuery();
		
		while(res.next()==true) {
			accno = res.getInt("accno");
			return true;
		}
		
		return false;
	}
	public boolean checkBalance() throws SQLException {
		String sql = "select bal from ABCBank where accno=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, accno);
		ResultSet res = pstm.executeQuery();
		
		while(res.next()==true) {
			bal = res.getInt("bal");
			return true;
		}
		
		return false;
	}
	public boolean changePwd() throws SQLException {
		String sql = "update ABCBank set password=? where accno=?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, pwd);
		pstm.setInt(2, accno);
		int x = pstm.executeUpdate();
		
		if(x>0) {
			return true;
		}
		return false;
	}
	public boolean transfer() throws SQLException {
		String sql = "select * from Abcbank where accno=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, raccno);
		ResultSet res = pstm.executeQuery();
		while(res.next()==true) {
			String sql1 = "update abcbank set bal=bal-? where accno=?";
			pstm = con.prepareStatement(sql1);
			pstm.setInt(1, bal);
			pstm.setInt(2, accno);
			int y1 = pstm.executeUpdate();
			if(y1>0) {
				String sql2 = "update abcbank set bal=bal+? where accno=?";
				pstm = con.prepareStatement(sql2);
				pstm.setInt(1, bal);
				pstm.setInt(2, raccno);
				int y2 = pstm.executeUpdate();
				if(y2>0) {
					String sql3 = "insert into Getstatement values(?,?,?)";
					pstm = con.prepareStatement(sql3);
					pstm.setInt(1, accno);
					pstm.setInt(2, raccno);
					pstm.setInt(3, bal);
					int y = pstm.executeUpdate();
					if(y>0) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			
			
		}
		return false;
	}
	public ArrayList getStatement() throws SQLException {
		String sql = "select * from getstatement where accno=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, accno);
		ResultSet res = pstm.executeQuery();
		while(res.next()==true) {
			sal.add(res.getInt("accno"));
			ral.add(res.getInt("raccno"));
			al.add(res.getInt("bal"));
		}
		return al;
	}
	public boolean applyLoan() throws SQLException {
		String sql = "select * from abcbank where accno=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, accno);
		ResultSet res = pstm.executeQuery();
		while(res.next()==true) {
			name = res.getString("name");
			email = res.getString("email");
			return true;
		}
		return false;
	}
}
