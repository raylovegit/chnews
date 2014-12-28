package hjj.chnews.comments;

import hjj.chnews.items.ItemsDAO;
import hjj.chnews.users.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.BaseService;
import common.util.BatchDelete;

public class CommentsServlet extends HttpServlet implements BaseService{
	private CommentsDAO commentsdao = new CommentsDAO();
    private String status =null;
    private String path=null;
    private HttpServletRequest request;
    private HttpServletResponse response;
	     /* (non-Javadoc)
	 * @see common.util.BaseService#bentchDelete()
	 */
	public void bentchDelete() throws Exception {
		// TODO Auto-generated method stub
		Object ids[] = (Object[])request.getAttribute("ids");
		String key = request.getParameter("key");
		String tableName=request.getParameter("tableName");
		try{
		new BatchDelete().batchDelete(ids, key, tableName);}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#create()
	 */
	public void create() throws Exception {
		// TODO Auto-generated method stub
		   int newsId =  Integer.parseInt(request.getParameter("newsId"));
		   String author = request.getParameter("author");
		   String content= request.getParameter("content");
		   Comments comments = new Comments();
		   comments.setNewsId(newsId);
		   comments.setAuthor(author);
		   comments.setContent(content);
		   Date date = new Date();
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  HH：mm:ss");
		   comments.setTime(sdf.format(date));
		   try{
			   commentsdao.create(comments);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#delete()
	 */
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
		   try{
			   Comments comments = new Comments();
			   comments.setId(id);
			   commentsdao.delete(comments);
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#isUnique()
	 */
	public void isUnique() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#list()
	 */
	public void list() throws Exception {
		// TODO Auto-generated method stub
		  String key;
		   String value;
			if(request.getParameter("key")!=null&&request.getParameter("value")!=null) 
			  {
				key= request.getParameter("key");
				value=request.getParameter("value");
			  }
			else {
				key ="";value="";
			}
			boolean isAnd =false;
			try{
				request.setAttribute("Clist",commentsdao.queryBy(key,value, isAnd));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="list.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#preCreate()
	 */
	public void preCreate() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#preUdate()
	 */
	public void preUdate() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#query()
	 */
	public void query() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#read()
	 */
	public void read() throws Exception {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
		   try{
			   Comments comments = new Comments();
			   comments.setId(id);
			  request.setAttribute("comments",commentsdao.read(comments)) ;
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
		   path="update.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#update()
	 */
	public void update() throws Exception {
		// TODO Auto-generated method stub
		   long id = Integer.parseInt(request.getParameter("id"));
		   int newsId =  Integer.parseInt(request.getParameter("newsId"));
		   String author = request.getParameter("author");
		   String content= request.getParameter("content");
		   Comments comments = new Comments();
		   comments.setId(id);
		   comments.setNewsId(newsId);
		   comments.setAuthor(author);
		   comments.setContent(content);
		   try{
			   commentsdao.update(comments);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
	}
		
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 this.request=request;
		 this.response=response;
		 status = request.getParameter("status");
		// System.out.println("items status。。。。。。"+status);
		 this.manage();
	}
	public void manage() throws ServletException, IOException  {
		if(status==null) {
			path="";
		}
	    if("delete".equals(status)){
	    	
	    	try{
	    		this.delete();
	    		this.list();
	    	}
	    	catch(Exception e){
				e.printStackTrace();
			   }
	    }
	    if("create".equals(status)){
	    
	    	try{
	    		this.create();
	    		this.list();
	    	}
	    	catch(Exception e){
				e.printStackTrace();
			   }
	    }
	    if("read".equals(status)){
	    	try{
	    		this.read();
	    	}
	    	catch(Exception e){
				e.printStackTrace();
			   }
	    }
	    if("update".equals(status)){
	    	
	    	try{
	    		this.update();
	    		this.list();
	    	}
	    	catch(Exception e){
				e.printStackTrace();
			   }
	    }
	    if("readAll".equals(status)){
	    	
	    	try{
	    		this.list();
	    	}
	    	catch(Exception e){
				e.printStackTrace();
			   }
	    }
		if("bentchdetele".equals(status)){
			try
			{
				this.bentchDelete();
				this.list();
			}
			catch(Exception e){
				e.printStackTrace();
			   }
		}
	     request.getRequestDispatcher(path).forward(request, response);
		   }

}
