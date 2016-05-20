package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	// JDBC ���������ƺ����ݿ�� URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/class?charset=utf-8";

    //  ���ݿ��ƾ��
    static final String USER = "root";
    static final String PASS = "root";
    
    Connection conn=null;
    Statement stmt=null;
    
    public DB(){
    	
    }
    public boolean query1(String sql){
    	try{
        	// ע�� JDBC ������
            Class.forName("com.mysql.jdbc.Driver");

            // ��һ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            // ִ�� SQL ��ѯ
            stmt = conn.createStatement();
            boolean rs =  stmt.execute(sql);
            return rs;

         
//            // ������
//            rs.close();
//            stmt.close();
//            conn.close();
         }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
         }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
         }finally{
//            // ��������ڹر���Դ�Ŀ�
//            try{
//               if(stmt!=null)
//                  stmt.close();
//            }catch(SQLException se2){
//            }// ���ǲ�����ʲô
//            try{
//               if(conn!=null)
//               conn.close();
//            }catch(SQLException se){
//               se.printStackTrace();
//            }//end finally try
         } //end try
		return true;
    	
    }
    
    public ResultSet query2(String sql){
    	try{
        	// ע�� JDBC ������
            Class.forName("com.mysql.jdbc.Driver");

            // ��һ������
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            // ִ�� SQL ��ѯ
            stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery(sql);
            return rs;

         
//            // ������
//            rs.close();
//            stmt.close();
//            conn.close();
         }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
         }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
         }finally{
//            // ��������ڹر���Դ�Ŀ�
//            try{
//               if(stmt!=null)
//                  stmt.close();
//            }catch(SQLException se2){
//            }// ���ǲ�����ʲô
//            try{
//               if(conn!=null)
//               conn.close();
//            }catch(SQLException se){
//               se.printStackTrace();
//            }//end finally try
         } //end try
		return null;
    	
    }
}