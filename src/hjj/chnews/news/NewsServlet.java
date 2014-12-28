package hjj.chnews.news;

import hjj.chnews.comments.Comments;
import hjj.chnews.comments.CommentsDAO;
import hjj.chnews.items.ItemsDAO;
import hjj.chnews.users.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.page.Page;
import common.page.PageUtil;
import common.util.BaseService;
import common.util.BatchDelete;

public class NewsServlet extends HttpServlet implements BaseService {
	final int size=20;
	NewsDAO newsdao = new NewsDAO(); 
	ItemsDAO itemsDao = new ItemsDAO();
	CommentsDAO commentsDao = new CommentsDAO();
	String status = null;
	String path ="common/error.jsp";
	HttpServletRequest request =null;
	HttpServletResponse response =null;
	HttpSession session=null;
	Page page = null;
	int currentpage=1;
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
		status=request.getParameter("status");
		this.request=request;
		this.response=response;
		this.session=request.getSession();
		if(request.getParameter("pageNum")!=null){
        	try{
        currentpage=Integer.parseInt(request.getParameter("pageNum"));
        	}catch(Exception e){e.printStackTrace();}
        }
		this.manage();
	}
    public void manage() throws IOException,ServletException {
    	 if(status!=null){
    		 if("query".equals(status)){
    			 try {
					this.query();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			   if("bentchDetele".equals(status)){
				   try{
					   this.bentchDelete();
					   this.list();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
			   }
			   if("updateVisitnum".equals(status)){
				   try{
					   this.updateVisitnum();
					   this.list();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
			   }
			   if("updateC".equals(status)){
				   try {
					this.updateC();
					this.query();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			   }
			   if("deleteC".equals(status)){
				   try {
					this.deleteC();
					 this.query();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			   }
			   request.getRequestDispatcher(path).forward(request, response);
		   }
    }
    
	public void updateVisitnum()throws Exception{
		  long id = Integer.parseInt(request.getParameter("id"));
		   try{
			  News news = new News();
              news.setId(id);
              news = newsdao.read(news);
              newsdao.updateVisit(news);
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
	}
	public void bentchDelete() throws Exception {
		// TODO Auto-generated method stub
		String [] ids = request.getParameterValues("ids");
		String key ="id";
		String tableName="news";
		try{
		new BatchDelete().batchDelete(ids, key, tableName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void create() throws Exception {
		   News news = new News();
		// TODO Auto-generated method stub
		   String title = request.getParameter("title");
		   String subTitle=request.getParameter("subTitle");
		   String sub2Title=request.getParameter("sub2Title");
		   String caption  =request.getParameter("caption");
		   String author = request.getParameter("author");
		   String newsFrom = request.getParameter("newsFrom");
		   //得到新闻添加时间
		   String newsTime = request.getParameter("newsTime");
		   news.setTime(newsTime);
		   
		   //拆分
		   String kind=request.getParameter("kindid");
		   int i=0;
		   if(kind!=null&&(i=kind.indexOf(","))!=-1){
			   int kindid=Integer.parseInt(kind.substring(0,i));
			   String kindName=kind.substring(i+1);
			   news.setKindid(kindid);
			   news.setKindName(kindName);
		   }
		   String type=request.getParameter("newsType");
		   int j=0;
		   if(type!=null&&(j=type.indexOf(","))!=-1){//indexOf()返回指定字符在此字符串中第一次出现处的索引。若无该字符，返回0
			   int newsType=Integer.parseInt(type.substring(0,j));
			   String typeName=type.substring(j+1);
			   news.setNewsType(newsType);
			   news.setTypeName(typeName);
		   }
		
		   news.setAuthor(author);
		   news.setCaption(caption);
		   news.setNewsFrom(newsFrom);
		   news.setSub2Title(sub2Title);
		   news.setSubTitle(subTitle);
		   news.setTitle(title);
		   try{
				newsdao.create(news);
				System.out.println("news:"+news);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
	}

	public void delete() throws Exception {
		// TODO Auto-generated method stub
		long id = Integer.parseInt(request.getParameter("id"));
		   try{
			  News news = new News();
			  news.setId(id);
			  newsdao.delete(news);
		   }
		   catch(Exception e){
			   e.printStackTrace();
			   System.out.println("delete:"+e);
		   }
	}

	public void isUnique() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void preCreate() throws Exception {
		String key="";
		String value="";
		boolean isAnd = false;
		try{
		request.setAttribute("ilist",itemsDao.queryBy(key, value, isAnd));
		}catch(Exception e){
			e.printStackTrace();
		}
		 path="WEB-INF/jsp/newsAction/create.jsp";
	}

	public void preUdate() throws Exception {
		long id = Integer.parseInt(request.getParameter("id"));
		   try{
			   News news = new News();
            news.setId(id);
			   request.setAttribute("news",newsdao.read(news));
			   request.setAttribute("ilist",itemsDao.queryBy("","",false));
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
		   path="WEB-INF/jsp/newsAction/update.jsp";
		
	}
//查看新闻对应的评论
	public void query() throws Exception {
       long id=0;
       try{
    	   id=Integer.parseInt(request.getParameter("id"));
    	   request.setAttribute("clist",commentsDao.query(id));//全部评论
       }catch(Exception e){
    	   e.printStackTrace();
       }
       path="WEB-INF/jsp/newsAction/comments.jsp";
		
	}

	public void read() throws Exception {
		// TODO Auto-generated method stub
		long id = Integer.parseInt(request.getParameter("id"));
		   try{
			   News news = new News();
               news.setId(id);
			   request.setAttribute("news",newsdao.read(news));
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
		  path="WEB-INF/jsp/newsAction/detail.jsp";
	}

	public void update() throws Exception {
		// TODO Auto-generated method stub
		  long id=Integer.parseInt(request.getParameter("id"));
		   News news = new News();
			// TODO Auto-generated method stub
			   String title = request.getParameter("title");
			   String subTitle=request.getParameter("subTitle");
			   String sub2Title=request.getParameter("sub2Title");
			   String caption  =request.getParameter("caption");
			   String author = request.getParameter("author");
			   String newsFrom = request.getParameter("newsFrom");
			   String newsTime=request.getParameter("newsTime");
			   String orderNum=request.getParameter("orderNum");
			   //拆分
			   String kind=request.getParameter("kindid");
			   int i=0;
			   if(kind!=null&&(i=kind.indexOf(","))!=-1){
				   int kindid=Integer.parseInt(kind.substring(0,i));
				   String kindName=kind.substring(i+1);
				   news.setKindid(kindid);
				   news.setKindName(kindName);
				   
			   }
			   String type=request.getParameter("newsType");
			   int j=0;
			   if(type!=null&&(j=type.indexOf(","))!=-1){
				   int newsType=Integer.parseInt(type.substring(0,j));
				   String typeName=type.substring(j+1);
				   news.setNewsType(newsType);
				   news.setTypeName(typeName);
			   }
			   news.setId(id);
			   news.setAuthor(author);
			   news.setCaption(caption);
			   news.setNewsFrom(newsFrom);
			   news.setSub2Title(sub2Title);
			   news.setSubTitle(subTitle);
			   news.setTitle(title);
			   news.setTime(newsTime);
			   news.setOrderNum(orderNum);
		   try{
				newsdao.update(news);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
	}
	
	//后面的代码稍做修改
	//第一次查询初始化page对象
	public void list() throws Exception {
		// TODO Auto-generated method stub
		  Integer key1=null;
		  String key2=null;
		  String value=null;
		  session.setAttribute("key1",null);
		  session.setAttribute("key2",null);
		  session.setAttribute("value",null);
		  if(request.getParameter("key1")!=null&&!("".equals("key1"))) key1=	Integer.parseInt(request.getParameter("key1"));
		  if(request.getParameter("value")!=null&&!("".equals(request.getParameter("value"))))
			  {
				key2=request.getParameter("key2");
				value=request.getParameter("value");
				session.setAttribute("key1",key1);
				session.setAttribute("key2",key2);
				session.setAttribute("value",value);
			  }
			boolean isAnd =false;
			try{
				int totalcounts = newsdao.getCount(key1,key2,value);
				page = new PageUtil().createPage(size, currentpage, totalcounts);
				session.setAttribute("page",page);
				request.setAttribute("ilist",itemsDao.queryBy("","",false));//查询新闻的类型
				request.setAttribute("nlist",newsdao.pageBreak(key1,key2, value, size, page.getBeginindex()));
			   
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/newsAction/list.jsp";
	}

  //后面的查询直接获得page对象和key，value
	public void pageBreak() throws Exception{
		  Integer key1=null;
		  String key2="";
		   String value="";
			if((session.getAttribute("key1")!=null||session.getAttribute("key2")!=null)&&session.getAttribute("value")!=null) 
			  {
				key1=(Integer)session.getAttribute("key1");
				key2=(String)session.getAttribute("key2");
				value=(String)session.getAttribute("value");
			  }
			try{
				page = (Page)session.getAttribute("page");
				page.setCurrentpage(currentpage);
				this.page=new PageUtil().createPage(size, currentpage,page.getTotalcounts());
				session.setAttribute("page",page);
				request.setAttribute("ilist",itemsDao.queryBy("","",false));//查询新闻的类型
				request.setAttribute("nlist",newsdao.pageBreak(key1,key2, value, size, this.page.getBeginindex()));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		   path="WEB-INF/jsp/newsAction/list.jsp";
	}
	//更新新闻评论
	public void updateC() throws Exception{
		long cid = Integer.parseInt(request.getParameter("cid"));
		try {
			commentsDao.update(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteC() throws Exception{
		Comments c = new Comments();
		long cid=Integer.parseInt(request.getParameter("cid"));
		c.setId(cid);
		commentsDao.delete(c);
	}
}