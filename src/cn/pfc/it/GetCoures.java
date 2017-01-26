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
 * Servlet implementation class GetCoures
 */
@WebServlet(description = "课表的数据请求", urlPatterns = { "/GetCoures" })
public class GetCoures extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String YearNo=request.getParameter("YearNo");
		String ClassNo=request.getParameter("ClassNo");
		//out.print(ClassNo);
//		YearNo="15";
//		ClassNo="3";
		try {
			SQLconnection sqLconnection=new SQLconnection();
			Statement statment = sqLconnection.getStatment();
			ResultSet resultSet = statment.executeQuery("select * from coures where 班级='"+YearNo+"软件技术"+ClassNo+"班"+"'");
			if (resultSet.next()) {
				
				JSONObject root=new JSONObject();
				String class_1_1 =resultSet.getString(2).trim();
				String class_1_2=resultSet.getString(3).trim();
				String class_1_3=resultSet.getString(4).trim();
				String class_1_4=resultSet.getString(5).trim();
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("1_1", class_1_1);
				jsonObject.put("1_2", class_1_2);
				jsonObject.put("1_3", class_1_3);
				jsonObject.put("1_4",class_1_4);
				root.append("day_1", jsonObject);
				
				String class_2_1 =resultSet.getString(6).trim();
				String class_2_2=resultSet.getString(7).trim();
				String class_2_3=resultSet.getString(8).trim();
				String class_2_4=resultSet.getString(9).trim();
				JSONObject jsonObject2=new JSONObject();
				jsonObject2.put("2_1", class_2_1);
				jsonObject2.put("2_2", class_2_2);
				jsonObject2.put("2_3", class_2_3);
				jsonObject2.put("2_4",class_2_4);
				root.append("day_2", jsonObject2);
				
				String class_3_1 =resultSet.getString(10).trim();
				String class_3_2=resultSet.getString(11).trim();
				String class_3_3=resultSet.getString(12).trim();
				String class_3_4=resultSet.getString(13).trim();
				JSONObject jsonObject3=new JSONObject();
				jsonObject3.put("3_1", class_3_1);
				jsonObject3.put("3_2", class_3_2);
				jsonObject3.put("3_3", class_3_3);
				jsonObject3.put("3_4",class_3_4);
				root.append("day_3", jsonObject3);
				
				String class_4_1 =resultSet.getString(14).trim();
				String class_4_2=resultSet.getString(15).trim();
				String class_4_3=resultSet.getString(16).trim();
				String class_4_4=resultSet.getString(17).trim();
				JSONObject jsonObject4=new JSONObject();
				jsonObject4.put("4_1", class_4_1);
				jsonObject4.put("4_2", class_4_2);
				jsonObject4.put("4_3", class_4_3);
				jsonObject4.put("4_4",class_4_4);
				root.append("day_4", jsonObject4);
				
				String class_5_1 =resultSet.getString(18).trim();
				String class_5_2=resultSet.getString(19).trim();
				JSONObject jsonObject5=new JSONObject();
				jsonObject5.put("5_1", class_5_1);
				jsonObject5.put("5_2", class_5_2);
				root.append("day_5", jsonObject5);
				
				out.print(root.toString());
				
			} else {

			}
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
