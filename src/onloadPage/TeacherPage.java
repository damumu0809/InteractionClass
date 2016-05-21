package onloadPage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;

/**
 * Servlet implementation class TeacherPage
 */
@WebServlet("/TeacherPage")
public class TeacherPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter( );
		
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>TeacherPage</title>");  
        out.println("</head>");
        out.println("<body>");
        
        //显示每次作业的所有提交文件
        DB db = new DB();
		String sqlSelect = "SELECT * FROM issueWork";
		ResultSet rs1 = db.query2(sqlSelect);
		try {
			while(rs1.next()){
				out.println("第"+rs1.getInt("id")+"次作业"+"</br>"+rs1.getString("theme")+"</br>");
				String sql = "SELECT * FROM homework WHERE taskNum="+rs1.getInt("id")+"";
				ResultSet rs2 = db.query2(sql);
				while(rs2.next()){
					out.println("<a href="+ rs2.getString("href") +">"+rs2.getString("file_name")+"</a>"+"</br>");
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//发布作业添加到这里
		
	}

}
