package cn.pfc.it;

import java.sql.ResultSet;
import java.sql.Statement;

public class GetAllInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLconnection sqLconnection;
		try {
			sqLconnection = new SQLconnection();
			Statement statment = sqLconnection.getStatment();
			ResultSet rs = statment.executeQuery("select * from students");
	        	while (rs.next()) {
	        			String id=rs.getString(1);
	            		String stuNo= rs.getString(2).trim();
	            		String stuName=rs.getString(3).trim();
	            		String IDnumber=rs.getString(8).trim();
	            		IDnumber=IDnumber.substring(12);
	            		System.out.println("update students set √‹¬Î='"+IDnumber+"' where id='"+id+"'");
	        	}
	        	sqLconnection.toClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}