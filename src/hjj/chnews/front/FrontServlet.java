package hjj.chnews.front;

import hjj.chnews.comments.Comments;
import hjj.chnews.comments.CommentsDAO;
import hjj.chnews.items.Items;
import hjj.chnews.items.ItemsDAO;
import hjj.chnews.news.News;
import hjj.chnews.news.NewsDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.page.Page;
import common.page.PageUtil;

public class FrontServlet extends HttpServlet {
    NewsDAO newsDao = new NewsDAO();
    ItemsDAO itemsDao = new ItemsDAO();
	CommentsDAO commentsDao = new CommentsDAO();
    String status=null;
    String path=null;
    Page page = null;
    int currentPage=1;
    final int size=15;
    HttpSession session=null;
    private HttpServletRequest request;
    private HttpServletResponse response;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           this.doPost(request, response);
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
		response.setCharacterEncoding("utf-8");
		this.request=request;
		this.response=response;
		this.session=request.getSession();
		status=request.getParameter("status");
		System.out.println("status。。。"+status);
		try{
			if(request.getParameter("num")!=null)
			currentPage=Integer.parseInt(request.getParameter("num"));
		}catch(Exception e){
		 e.printStackTrace();	
		}
		System.out.println("page。。。"+currentPage);
		this.manage();
	}

  public void manage() throws ServletException, IOException{
	  if(status!=null){
		  if("index".equals(status)){
			  try {
				this.index();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if("page".equals(status)){
			  try {
				this.page();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if("read".equals(status)){
			  try {
				this.read();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if("search".equals(status)){
			  try {
				this.search();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if("doSearch".equals(status)){
			  try {
				this.doSearch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if("pingLun".equals(status)){
			  try {
				this.pingLun();
				this.read();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }
	  request.getRequestDispatcher(path).forward(request,response);
  }
  
  
  
  //方法
  public void index() throws SQLException{
	  Map map = new HashMap();
	  for(int i=1;i<=10;i++){
		  List list=newsDao.queryByType(i,10, 0);//按降序查询前十条记录
		  map.put(i,list);
	  }
	  request.setAttribute("map",map);
	  path="WEB-INF/jsp/front/list.jsp";
  }
  
  public void page() throws SQLException{
	  int kindid=Integer.parseInt(request.getParameter("kindid"));
	  Items items = new Items();
	  items.setId(kindid);
	  items = itemsDao.read(items);
	  request.setAttribute("items",items);
	  if(currentPage==1){
		  int totalcounts=newsDao.getCount(kindid,null,null);
		  page=new PageUtil().createPage(size, currentPage, totalcounts);
	  }
	  else{
		  Page p=(Page)session.getAttribute("page");
		  page=new PageUtil().createPage(size, currentPage,p.getTotalcounts());
	  }
	  session.setAttribute("page",page);
	  request.setAttribute("nlist",newsDao.queryByType(kindid, size,page.getBeginindex()));
	  request.setAttribute("vlist",newsDao.queryByVisit(0,10));
	  path="WEB-INF/jsp/front/more.jsp";
  }
  
  public void read()throws SQLException{
	  long id=Integer.parseInt(request.getParameter("id"));
	  News news = new News();
	  news.setId(id);
	  news = newsDao.read(news);
	  request.setAttribute("news",news);//查询新闻以后更新访问量
	  newsDao.updateVisit(news); //更新访问量
	  //查询相关新闻
	  request.setAttribute("about",newsDao.queryByType("sub_title",news.getTitle(),5,0));
	  request.setAttribute("vlist",newsDao.queryByVisit(0,10));//查询排行榜
	  request.setAttribute("clist",commentsDao.queryShow(id,"true"));//查询全部显示的评论
	  path="WEB-INF/jsp/front/detail.jsp";
  }
  public void doSearch() throws SQLException{
	     String keyword = request.getParameter("keyword");
	     session.setAttribute("keyword",keyword);
	     int totalcounts=newsDao.getCount(keyword);
		 page=new PageUtil().createPage(size, currentPage, totalcounts);
		 session.setAttribute("page",page);
		 request.setAttribute("nlist",newsDao.queryByKey(keyword, size,page.getBeginindex()));
		 request.setAttribute("vlist",newsDao.queryByVisit(0,10));
		 path="WEB-INF/jsp/front/search.jsp";
  }
  
  
 public void search() throws SQLException{
	      String keyword=(String)session.getAttribute("keyword");
		  Page p=(Page)session.getAttribute("page");
		  page=new PageUtil().createPage(size, currentPage,p.getTotalcounts());
	      session.setAttribute("page",page);
	      request.setAttribute("nlist",newsDao.queryByKey(keyword, size,page.getBeginindex()));
	      request.setAttribute("vlist",newsDao.queryByVisit(0,10));
	     path="WEB-INF/jsp/front/search.jsp";
 }
 
 public void pingLun()throws SQLException{
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
		   commentsDao.create(comments);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	
 }
}
