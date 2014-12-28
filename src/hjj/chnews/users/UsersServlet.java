package hjj.chnews.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.page.Page;
import common.page.PageUtil;
import common.security.MD5;
import common.util.*;

public class UsersServlet extends HttpServlet implements BaseService {
	final int size=20;
    private UsersDAO usersdao = new UsersDAO();
	private String status=null;
	private String path="common/error.jsp";
	private HttpServletRequest request;
	private HttpServletResponse response;
	HttpSession session=null;
	Page page = null;
	int currentpage=1;
	/* (non-Javadoc)
	 * @see common.util.BaseService#bentchDelete()
	 */
	public void exit(){
		//session.removeAttribute("user");
		session.invalidate();
		path="WEB-INF/jsp/usersAction/login.jsp";
	}
	public void preLogin(){
		path="WEB-INF/jsp/usersAction/login.jsp";
	}
	public void login(){
		   String loginName=request.getParameter("loginName");
		   String passwords="";
		   if(request.getParameter("passwords")!=null)
			   
			   passwords =request.getParameter("passwords");
		   		//passwords =MD5.encrypt(request.getParameter("passwords"));
		   //System.out.println("passwords.................."+passwords);
		   try{
			   Users user = null;
			   user=usersdao.login(loginName,passwords);
			   if(user!=null) {
				   path="base/main.jsp";
			       session.setAttribute("user",user);
			   }
			   else
				   path="WEB-INF/jsp/usersAction/login.jsp";
		   }
		   catch(Exception e){
			   e.printStackTrace();
		   }
	}
	public void bentchDelete() throws Exception {
		// TODO Auto-generated method stub
		String [] ids = request.getParameterValues("ids");
		String key ="id";
		String tableName="users";
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
		   String loginName = request.getParameter("loginName");
		   //String passwords = request.getParameter("passwords");
		   String passwords="";
		   if(request.getParameter("passwords")!=null)
		   passwords =MD5.encrypt(request.getParameter("passwords"));
		   String des  = request.getParameter("des");
		   Users users = new Users();
		   users.setLoginName(loginName);
		   users.setPasswords(passwords);
		   users.setDes(des);
			try{
				usersdao.create(users);
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
			   Users users = new Users();
			   users.setId(id);
			   usersdao.delete(users);
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
	

	public void preCreate() throws Exception {
		path="WEB-INF/jsp/usersAction/create.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#preUdate()
	 */
	public void preUdate() throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		   try{
			   Users users = new Users();
			   users.setId(id);
               request.setAttribute("user",usersdao.read(users));
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
		   path="WEB-INF/jsp/usersAction/update.jsp";
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
			   Users users = new Users();
			   users.setId(id);
            request.setAttribute("user",usersdao.read(users));
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
		   //path="usersAction/update.jsp";
	}

	/* (non-Javadoc)
	 * @see common.util.BaseService#update()
	 */
	public void update() throws Exception {
		// TODO Auto-generated method stub
		   String msg=""; 
		   String loginName = request.getParameter("loginName");
		   String password=((Users)session.getAttribute("user")).getPasswords();//加密以后的密码
		   String old_p = MD5.encrypt(request.getParameter("old_p"));//加密
		   String new_p =MD5.encrypt(request.getParameter("new_p"));
		   String repeat_p=MD5.encrypt(request.getParameter("repeat_p"));
		   String des  = request.getParameter("des");
		   int id = Integer.parseInt(request.getParameter("id"));
		   Users users = new Users();
		   users.setId(id);
		   users.setLoginName(loginName);
		   users.setPasswords(new_p);
		   users.setDes(des);
		   if(!old_p.equals(password)){
			   msg="输入的旧密码有误";
		   }else if(!new_p.equals(repeat_p)){
			   msg="重复输入密码有误";
		   }else{
			try{
				usersdao.update(users);
				msg="修改密码成功";
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   }
		   request.setAttribute("msg",msg);
		   path="WEB-INF/jsp/usersAction/update.jsp";
	}
	
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
				int totalcounts = usersdao.getCount(key, value);
				page = new PageUtil().createPage(size, currentpage, totalcounts);
				//System.out.println("page:"+page.getBeginindex());
				session.setAttribute("page",page);
				request.setAttribute("ulist",usersdao.pageBreak(key, value, size, page.getBeginindex()));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/usersAction/list.jsp";
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
				//System.out.println("page:"+page.getBeginindex());
				//System.out.println("page:"+(usersdao.pageBreak(key, value, size, page.getBeginindex())).size());
				session.setAttribute("page",page);
				request.setAttribute("ulist",usersdao.pageBreak(key, value, size, page.getBeginindex()));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/usersAction/list.jsp";
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        status=request.getParameter("status");
	        this.request=request;
	        this.response=response;
	        this.session=this.request.getSession();
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
		if("exit".equals(status)){
			this.exit();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if("preLogin".equals(status)){
			this.preLogin();
		}
		if("login".equals(status)){
			try{
				this.login();
	    	}
	    	catch(Exception e){
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
	    if("update".equals(status)){
	    	
	    	try{
	    		this.update();
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
	
