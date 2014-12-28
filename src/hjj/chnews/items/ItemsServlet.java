package hjj.chnews.items;

import hjj.chnews.users.Users;
import common.page.Page;
import common.page.PageUtil;
import common.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemsServlet extends HttpServlet implements BaseService{
     private ItemsDAO itemsdao = new ItemsDAO();
     private String status =null;
     private String path="common/error.jsp";
     private HttpServletRequest request;
     private HttpServletResponse response;
     final int size=20;
     int currentpage=1;
     HttpSession session=null;
     Page page = null;
	/* (non-Javadoc)
	 * @see common.util.BaseService#bentchDelete()
	 */
	public void bentchDelete() throws Exception {
		// TODO Auto-generated method stub
		String [] ids = request.getParameterValues("ids");
		String key = "id";
		String tableName="items";
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
		   String title= request.getParameter("title");
		   Items items = new Items();
		   items.setTitle(title);
		   try{
				itemsdao.create(items);
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
			  Items items = new Items();
			  items.setId(id);
			  itemsdao.delete(items);
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
	//第一次查询初始化page对象
	public void list() throws Exception {
		// TODO Auto-generated method stub
		  String key;
		   String value;
		   session.setAttribute("key",null);
		   session.setAttribute("value",null);
			if(request.getParameter("key")!=null&&request.getParameter("value")!=null) 
			  {
				key= request.getParameter("key");
				value=request.getParameter("value");
				session.setAttribute("key",key);
				session.setAttribute("value",value);
			  }
			else {
				key ="";value="";
			}
			boolean isAnd =false;
			try{
				int totalcounts = itemsdao.getCount(key, value);
				page = new PageUtil().createPage(size, currentpage, totalcounts);
				System.out.println("page:"+page.getBeginindex());
				session.setAttribute("page",page);
				request.setAttribute("ilist",itemsdao.pageBreak(key, value, size, page.getBeginindex()));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/itemsAction/list.jsp";
	}

  //后面的查询直接获得page对象和key，value
	public void pageBreak() throws Exception{
		  String key="";
		   String value="";
			if(session.getAttribute("key")!=null&&session.getAttribute("value")!=null) 
			  {
				key=(String)session.getAttribute("key");
				value=(String)session.getAttribute("value");
			  }
			try{
				page = (Page)session.getAttribute("page");
				page.setCurrentpage(currentpage);
				page=new PageUtil().createPage(size, currentpage,this.page.getTotalcounts());
				System.out.println("page:"+page.getBeginindex());
				System.out.println("page:"+(itemsdao.pageBreak(key, value, size, page.getBeginindex())).size());
				session.setAttribute("page",page);
				request.setAttribute("ilist",itemsdao.pageBreak(key, value, size, page.getBeginindex()));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/itemsAction/list.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#preCreate()
	 */
	public void preCreate() throws Exception {
		path="WEB-INF/jsp/itemsAction/create.jsp";
		
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#preUdate()
	 */
	public void preUdate() throws Exception {
		  int id =Integer.parseInt(request.getParameter("id"));
		   Items items = new Items();
		   items.setId(id);
		   try{
				request.setAttribute("items",itemsdao.read(items));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
         path="WEB-INF/jsp/itemsAction/update.jsp";		
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
		  int id =Integer.parseInt(request.getParameter("id"));
		   Items items = new Items();
		   items.setId(id);
		   try{
				request.setAttribute("items",itemsdao.read(items));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
			path="update.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#update()
	 */
	public void update() throws Exception {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		int id = Integer.parseInt(request.getParameter("id"));
		Items items = new Items();
		items.setId(id);
		items.setTitle(title);
		   try{
			 itemsdao.update(items);
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
		 session=this.request.getSession();
		 if(request.getParameter("pageNum")!=null){
	        	try{
	        currentpage=Integer.parseInt(request.getParameter("pageNum"));
	        	}catch(Exception e){e.printStackTrace();}
	        }
		 this.manage();
	}
	public void manage() throws ServletException, IOException  {
		if(status==null) {
		}
		if("pageBreak".equals(status)){
			try {
				this.pageBreak();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if("preCreate".equals(status)){
			try {
				this.preCreate();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	    if("preUpdate".equals(status)){
	    	try {
				this.preUdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
