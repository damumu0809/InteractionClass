package uploadWork;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.DB;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadWork")



public class UploadWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 100000000 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;

	   public void init( ){
	      // ��ȡ�ļ������洢��λ��
	      filePath = 
	             getServletContext().getInitParameter("file-upload"); 
	   }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadWork() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���������һ���ļ��ϴ�����
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html;charset=utf-8");
	      java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // �ļ���С�����ֵ�����洢���ڴ���
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));
	      
	      // ����һ���µ��ļ��ϴ��������
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // �����ϴ����ļ���С�����ֵ
	      upload.setSizeMax( maxFileSize );
	      //����
	      upload.setHeaderEncoding("utf-8");
	      //����Map�䵱�����򣬴�����
	      Map<String,String> map = new TreeMap<String, String>();
	      String key;
	      String value;

	      try{ 
	      // �������󣬻�ȡ�ļ���
	      List<FileItem> fileItems = upload.parseRequest(request);
	      // �����ϴ����ļ���
	      //Iterator i = fileItems.iterator();
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Servlet upload</title>");  
	      out.println("</head>");
	      out.println("<body>");
	      
	      String fieldName;
	      String fileName = null;
	      String contentType;
	      boolean isInMemory;
	      long sizeInBytes;
	      
	      for(FileItem fi :fileItems){
	      
	         if ( !fi.isFormField () )	
	         {
	            // ��ȡ�ϴ��ļ��Ĳ���
	        	//hidden����Ĵ��� ��������java.lang.NullPointerException
	        	//Object taskNum = request.getAttribute("taskNum");
	            fieldName = new String(fi.getFieldName().getBytes("GB2312"),"iso8859-1");
	            fileName = fi.getName();
	            contentType = fi.getContentType();
	            isInMemory = fi.isInMemory();
	            sizeInBytes = fi.getSize();
	            // д���ļ�
	            filePath = getServletContext().getInitParameter("file-upload");
	            
	            if( fileName.lastIndexOf("\\") >= 0 ){
	            	filePath = filePath + fileName.substring( fileName.lastIndexOf("\\")+1);
	               file = new File(filePath ) ;
	            }else{
	            	filePath = filePath + fileName.substring(fileName.lastIndexOf("\\")+1);
	                file = new File(filePath ) ;
	            }
	           
	            fi.write( file ) ;
	            fileName = fileName.substring( fileName.lastIndexOf("\\")+1);
	            out.println("Uploaded Filename: " + fileName + "<br>");
	        System.out.println("1");
	            
	         }else {
	        	 key = fi.getFieldName();
	        System.out.println(key);
	        	 value = fi.getString();
	        System.out.println(value);
	        	 map.put(key, value);
	        System.out.println("2");	
			}
	       
	      }
	    //�ϴ�ʱ��
      	Date date = new Date();
      	
      	//ʱ���ʽת��
      	SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
      	String uploadTime = ft.format(date);
      	
      	//�������ݿ�
	      	DB db = new DB();
	      
          String sqlInsert;
          String sqlSelect;
      	
          //д�����ݿ�
   System.out.println(map.get("taskNum"));
          int taskNum = Integer.parseInt(map.get("taskNum"));
          
          
          sqlInsert = "INSERT INTO homework(file_name, href, owner, time, taskNum)"+
          " VALUES (\""+fileName+"\",\""+ filePath +"\",\""+"xiaomu\",\""+uploadTime+"\",\""+taskNum+"\")";
     
          /*
           * \�ᱻת�壬����'\'Ҳ��������ʽ�е�ת���ַ���replaceAll �Ĳ�������������ʽ����
           * ��Ҫ����������һ�������ԣ�\\\\��javaת����\\,\\�ֱ�������ʽת����\��
           */
          sqlInsert = sqlInsert.replaceAll("\\\\","/");
    System.out.println(sqlInsert);
    System.out.println("3");      
          boolean rs1 = db.query1(sqlInsert);
        //ʵ��alert֮������תҳ��
  	    out.print("<script type='text/javascript'>alert('�ϴ��ɹ���');window.location.href='./StudentPage';</script>");

	      
	      /*
	       * ִ����executeQuery������ִ��executeQuery
	       */
	     /*
	      //��ѯ���
          sqlSelect = "SELECT * FROM homework WHERE owner='ll'";
          ResultSet rs2 = db.query2(sqlSelect);
          
	       try{
	    	   while(rs2.next()){
	         		out.println("<a href="+ rs2.getString("href") +">"+rs2.getString("file_name")+"</a>"+"</br>");
	         		System.out.println(rs2.getString("href"));
	         	}
	       }
	       catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/
	         	
	      out.println("</body>");
	      out.println("</html>");
	    
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }
	   
	    
	    //response.sendRedirect("./index.html");
	    //ҳ���λ��
	    
	    
	    
	}
}
