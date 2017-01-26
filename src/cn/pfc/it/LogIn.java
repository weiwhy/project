package cn.pfc.it;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String stuNo = request.getParameter("stuNo");
		String password=request.getParameter("password");
		
		try {
			SQLconnection sqLconnection=new SQLconnection();
			Statement statment = sqLconnection.getStatment();
			ResultSet resultSet = statment.executeQuery("select * from students where Ñ§ºÅ='"+stuNo+"'");
			if (resultSet.next()) {
				String thepass = resultSet.getString(13);
				if (password.equals(thepass)) {
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("msg", "ok");
					out.print(jsonObject.toString());
				}
			} else {
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("msg", "404");
					out.print(jsonObject.toString());
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
