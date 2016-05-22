package votePage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import database.DB;

/**
 * Servlet implementation class VotePage
 */
@WebServlet("/VotePage")
public class VotePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		java.io.PrintWriter out = response.getWriter( );	
		
		//��ȡ���ݿ�ͶƱ��¼
		DB db = new DB();
		String sql1 = "SELECT * FROM vote";
		String sql2 = "SELECT * FROM voteRecord";
		
		//ͶƱid�����⡢ѡ�Ʊ������ѡ��ѡ
		String theme;
		int voteId;
		String option1, option2, option3, option4, option5, option6;
		int number1, number2, number3, number4, number5, number6;
		int multipleChoice;
		
		//��¼�Ƿ���ͶƱ
		boolean hasVoted = false;
		
		List allVote =  new ArrayList();
		JSONObject vote ;
		
		ResultSet rs1 = db.query2(sql1);
		try {
			while(rs1.next()){
				
				voteId = rs1.getInt("id");
				theme = rs1.getString("theme");
				option1 = rs1.getString("option1");
				option2 = rs1.getString("option2");
				option3 = rs1.getString("option3");
				option4 = rs1.getString("option4");
				option5 = rs1.getString("option5");
				option6 = rs1.getString("option6");
				number1 = rs1.getInt("number1");
				number2 = rs1.getInt("number2");
				number3 = rs1.getInt("number3");
				number4 = rs1.getInt("number4");
				number5 = rs1.getInt("number5");
				number6 = rs1.getInt("number6");
				multipleChoice = rs1.getInt("multipleChoice");
				
				
				//��ѯ�Ƿ���ͶƱ
				sql2 = "SELECT * FROM voteRecord WHERE voteId=\""+voteId+"\" AND person='xiaomu'";
				ResultSet rs2 = db.query2(sql2);
				
				if(rs2.next()){
					//��ͶƱ��ʾͶƱ���
					vote = new JSONObject();
					vote.put("theme", theme);
					vote.put("voteId", voteId);
					vote.put("option1", option1);
					vote.put("option2", option2);
					vote.put("option3", option3);
					vote.put("option4", option4);
					vote.put("option5", option5);
					vote.put("option6", option6);
					vote.put("number1", number1);
					vote.put("number2", number2);
					vote.put("number3", number3);
					vote.put("number4", number4);
					vote.put("number5", number5);
					vote.put("number6", number6);
					vote.put("multipleChoice", multipleChoice);
					vote.put("hasVoted", hasVoted);
				}else {
					//δͶƱ��ʾͶƱ
					hasVoted = false;
					vote = new JSONObject();
					vote.put("theme", theme);
					vote.put("voteId", voteId);
					vote.put("option1", option1);
					vote.put("option2", option2);
					vote.put("option3", option3);
					vote.put("option4", option4);
					vote.put("option5", option5);
					vote.put("option6", option6);
					vote.put("multipleChoice", multipleChoice);
					vote.put("hasVoted", hasVoted);
				}
				allVote.add(vote);
				
			}
			JSONObject message = new JSONObject();
			message.put("code", 0);
			message.put("list", allVote);
			
			out.println(message.toString());
			//��ǰ�˸���multipleChoice�����ص�ѡ���Ƕ�ѡ��
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
