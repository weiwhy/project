package cn.pfc.it;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class EetStuInfo
 */
@WebServlet("/EetStuInfo")
public class GetStuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String stuNo = request.getParameter("stuNo");
		//stuNo="150110318";
		SQLconnection sqLconnection;
		try {
			sqLconnection = new SQLconnection();
			Statement statment = sqLconnection.getStatment();
			ResultSet rs = statment.executeQuery("select * from students where Ñ§ºÅ='"+stuNo+"'");
	        	while (rs.next()) {
	        		JSONObject msg=new JSONObject();
	        		msg.put("msg", "OK");
	            		String stuNo_ = rs.getString(2);
	            		String stuName=rs.getString(3);
	            		String department=rs.getString(4);
	            		String zhuanye=rs.getString(5);
	            		String nianji=rs.getString(6);
	            		String birthday=rs.getString(7);
	            		String idnumber=rs.getString(8);
	            		String sex=rs.getString(9);
	            		String banji=rs.getString(10);
	            		String sushe=rs.getString(11);
	            		String shengyuandi=rs.getString(12);
	            		JSONObject jsonObject=new JSONObject();
	            		jsonObject.put("stuNo", stuNo_);
	            		jsonObject.put("stuName", stuName);
	            		jsonObject.put("department", department);
	            		jsonObject.put("zhuanye", zhuanye);
	            		jsonObject.put("nianji", nianji);
	            		jsonObject.put("birthday", birthday);
	            		jsonObject.put("idnumber", idnumber);
	            		jsonObject.put("sex", sex);
	            		jsonObject.put("banji", banji);
	            		jsonObject.put("sushe", sushe);
	            		jsonObject.put("shengyudi", shengyuandi);
	            		msg.put("values",jsonObject);
	            		out.print(msg.toString());
//	            		out.println(stuNo_+"<br>");
//	            		out.println(stuName+"<br>");
	        	}
	        	sqLconnection.toClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
