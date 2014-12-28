package hjj.chnews.news;

/**
 * @author sql
 *@version:2.0
 * @time Jul 20, 2010
 * @description:新闻的增删查改功能实现类
 */
import hjj.chnews.items.Items;
import hjj.chnews.users.Users;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.util.BaseDao;
import common.util.DBConnection;

public class NewsDAO implements BaseDao<News> {
	// 批量删除
	public void bentchDelete(Object[] ids) throws SQLException {
		// TODO Auto-generated method stub
	}

	// 插入数据
	public void create(News news) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into news(title,sub_title,sub2_title,caption,kindid,newsType,time,author,visitnum,news_from,kindName,typeName,url) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getSubTitle());
			pstmt.setString(3, news.getSub2Title());
			pstmt.setString(4, news.getCaption());
			pstmt.setInt(5, news.getKindid());
			pstmt.setInt(6, news.getNewsType());
			pstmt.setString(7,news.getTime());
			pstmt.setString(8, news.getAuthor());
			pstmt.setInt(9, news.getVisitnum());
			pstmt.setString(10, news.getNewsFrom());
			pstmt.setString(11,news.getKindName());
			pstmt.setString(12,news.getTypeName());
			if(news.getNewsType()==1)  
		    {news.setUrl(this.subString(news.getCaption()));}//处理图片新闻
			pstmt.setString(13,news.getUrl());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlException) {
			throw sqlException;
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	// 删除数据 当删除新闻时，关于这条新闻的评论也全部被删除
	public void delete(News news) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from news where id=?";
		PreparedStatement pstmt = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1, news.getId());
			//System.out.println("pstmt。。。。。。" + pstmt);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void deleteBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<News> queryBy(String key, String value, boolean isAnd)
			throws SQLException {//模糊查询和查询全部，这两个功能都可以实现
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sql;
		if (key != "" && value != "")
			sql = "select * from news where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select * from news ";
		sql+=" order by id desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		News news = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			//System.out.println("pstmt。。。。。。"+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setSubTitle(rs.getString(3));
				news.setSub2Title(rs.getString(4));
				news.setCaption(rs.getString(5));
				news.setKindid(rs.getInt(6));
				news.setNewsType(rs.getInt(7));
				news.setTime(rs.getString(8));
				news.setAuthor(rs.getString(9));
				news.setVisitnum(rs.getInt(10));
				news.setNewsFrom(rs.getString(11));
				news.setKindName(rs.getString(12));
				news.setTypeName(rs.getString(13));
				list.add(news);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public Collection<News> queryByOrder(String key, String value, boolean isAnd,
			String order, boolean isUp) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public News read(News news) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from news where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1, news.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setSubTitle(rs.getString(3));
				news.setSub2Title(rs.getString(4));
				news.setCaption(rs.getString(5));
				news.setKindid(rs.getInt(6));
				news.setNewsType(rs.getInt(7));
				news.setTime(rs.getString(8));
				news.setAuthor(rs.getString(9));
				news.setVisitnum(rs.getInt(10));
				news.setNewsFrom(rs.getString(11));
				news.setKindName(rs.getString(12));
				news.setTypeName(rs.getString(13));
				news.setUrl(rs.getString(14));
				news.setOrderNum(rs.getString(15));
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return news;
	}

	public void update(News news) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update news set title=?,sub_title=?,sub2_title=?,caption=?,kindid=?,newsType=?,author=?,visitnum=? ,news_from=?,kindName=?,typeName=?,url=?,time=?,ordernum=? where id=?";
		PreparedStatement pstmt = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getSubTitle());
			pstmt.setString(3, news.getSub2Title());
			pstmt.setString(4, news.getCaption());
			pstmt.setInt(5, news.getKindid());
			pstmt.setInt(6, news.getNewsType());
			pstmt.setString(7, news.getAuthor());
			pstmt.setInt(8, news.getVisitnum());
			pstmt.setString(9, news.getNewsFrom());
			pstmt.setString(10,news.getKindName());
			pstmt.setString(11,news.getTypeName());
			
			if(news.getNewsType()==1)  
		    {news.setUrl(this.subString(news.getCaption()));}//处理图片新闻
			pstmt.setString(12,news.getUrl());
			pstmt.setString(13,news.getTime());
			pstmt.setString(14,news.getOrderNum());
			pstmt.setLong(15, news.getId());
			pstmt.executeUpdate();
		} catch (SQLException sqlException) {
			throw sqlException;
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	public void updateVisit(News news) throws SQLException{
		String sql = "update news set visitnum=visitnum+1 where id=?";
		PreparedStatement pstmt = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
		    pstmt.setLong(1, news.getId());
			pstmt.executeUpdate();
		} catch (SQLException sqlException) {
			throw sqlException;
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	//分页查询
	public Collection<News> pageBreak(String key, String value, int size,
			int beginIndex) throws SQLException {
		String sql="";
		List list = new ArrayList();
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql = "select * from news where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select * from news ";
		sql+=" order by id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		News news = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setSubTitle(rs.getString(3));
				news.setSub2Title(rs.getString(4));
				news.setCaption(rs.getString(5));
				news.setKindid(rs.getInt(6));
				news.setNewsType(rs.getInt(7));
				news.setTime(rs.getString(8));
				news.setAuthor(rs.getString(9));
				news.setVisitnum(rs.getInt(10));
				news.setNewsFrom(rs.getString(11));
				news.setKindName(rs.getString(12));
				news.setTypeName(rs.getString(13));
				list.add(news);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	//查询总记录数
	public int getCount(String key,String value)throws SQLException {
		String sql="";
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql = "select count(id) as num from news where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select count(id) as num from news ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCounts=0;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCounts=rs.getInt("num");
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return totalCounts;
	}
	
	
//重构方法
	public Collection<News> queryBy(Integer kindid,String key, String value, boolean isAnd)
	throws SQLException {
// TODO Auto-generated method stub
   List list = new ArrayList();
   String sql="select * from news where 1=1";
	if(kindid!=null&&kindid!=0) sql+=" and kindid="+kindid;
	if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
		sql+=" and " + key + " like '%" + value+ "%'";
	sql+=" order by id desc limit ?,?";
PreparedStatement pstmt = null;
ResultSet rs = null;
News news = null;
try {
	DBConnection dbc = new DBConnection();
	pstmt = dbc.getConnection().prepareStatement(sql);
	rs = pstmt.executeQuery();
	while (rs.next()) {
		news = new News();
		news.setId(rs.getLong(1));
		news.setTitle(rs.getString(2));
		news.setSubTitle(rs.getString(3));
		news.setSub2Title(rs.getString(4));
		news.setCaption(rs.getString(5));
		news.setKindid(rs.getInt(6));
		news.setNewsType(rs.getInt(7));
		news.setTime(rs.getString(8));
		news.setAuthor(rs.getString(9));
		news.setVisitnum(rs.getInt(10));
		news.setNewsFrom(rs.getString(11));
		news.setKindName(rs.getString(12));
		news.setTypeName(rs.getString(13));
		list.add(news);
	}
} catch (IOException io) {
	io.printStackTrace();
} catch (Exception exception) {
	exception.printStackTrace();
}
return list;
}

	
	//分页查询
	public Collection<News> pageBreak(Integer kindid,String key, String value, int size,
			int beginIndex) throws SQLException {
		List list = new ArrayList();
		String sql="select * from news where 1=1";
		if(kindid!=null&&kindid!=0) sql+=" and kindid="+kindid;
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql+=" and " + key + " like '%" + value+ "%'";
		sql+=" order by id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		News news = null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			System.out.println("list:pstmt:"+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setSubTitle(rs.getString(3));
				news.setSub2Title(rs.getString(4));
				news.setCaption(rs.getString(5));
				news.setKindid(rs.getInt(6));
				news.setNewsType(rs.getInt(7));
				news.setTime(rs.getString(8));
				news.setAuthor(rs.getString(9));
				news.setVisitnum(rs.getInt(10));
				news.setNewsFrom(rs.getString(11));
				news.setKindName(rs.getString(12));
				news.setTypeName(rs.getString(13));
				list.add(news);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	//根据类型查询总记录数查询总记录数
	public int getCount(Integer kindid,String key,String value) throws SQLException {
		String sql="select count(id) as num from news where 1=1";
		if(kindid!=null&&kindid!=0) sql+=" and kindid="+kindid;
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql+=" and " + key + " like '%" + value+ "%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCounts=0;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCounts=rs.getInt("num");
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return totalCounts;
	}
	
	
	//前台新闻
	//按新闻类型查询新闻(查询日期，新闻类型，标题，新闻id)
	public List<News> queryByType(int kindid,int size,int beginIndex) throws SQLException {
		List<News> list = new ArrayList<News>();
		String sql="select id,title,time,url,visitnum from news where kindid=? order by ordernum, id desc limit ?,?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try{
			DBConnection dbc = new DBConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,kindid);
			pstmt.setInt(2,beginIndex);
			pstmt.setInt(3,size);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setKindid(kindid);
				news.setTime(rs.getString(3));
				news.setUrl(rs.getString(4));
				news.setVisitnum(rs.getInt(5));
				list.add(news);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	//截取字符串
	public String subString(String caption) throws SQLException{
		String c = "src=\"(.*?)\"";
		Pattern p = Pattern.compile(c);
		Matcher m = p.matcher(caption);
		String sub="";
		if(m.find()){
			String str=m.group();
			if(str.length()>=4)
				sub=str.substring(4);
		}
		return sub;
	}

	
	//查询相关新闻	
	public List<News> queryByType(String key,String value,int size,int beginIndex) throws SQLException {
		List<News> list = new ArrayList<News>();
		String sql="select id,title,time,kindid,url from news where "+key+" like '%"+value+"%' order by id desc limit ?,?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try{
			DBConnection dbc = new DBConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setTime(rs.getString(3));
				news.setKindid(rs.getInt(4));
				news.setUrl(rs.getString(5));
				list.add(news);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//按新闻的访问量查询
	public List<News> queryByVisit(int beginIndex,int size){
		List<News> list = new ArrayList<News>();
		String sql="select id,title from news order by visitnum desc limit ?,?";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try{
			DBConnection dbc = new DBConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				list.add(news);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	//按新闻标题,作者或者小标题查询
	public List<News> queryByKey(String keyword,int size,int beginIndex){
		List<News> list = new ArrayList<News>();
		String sql="select id,title,time,visitnum from news where title like '%"+keyword+"%' or sub_title like '%"+keyword+"%' or author like '%"+keyword+"%'";
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		sql+=" limit ?,?";
		try{
			DBConnection dbc = new DBConnection();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			System.out.println("pstmt:"+pstmt);
			rs=pstmt.executeQuery();
			while(rs.next()){
				News news = new News();
				news.setId(rs.getLong(1));
				news.setTitle(rs.getString(2));
				news.setTime(rs.getString(3));
				news.setVisitnum(rs.getInt(4));
				list.add(news);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("size:"+list.size());
		return list;
	}
	public int getCount(String keyword){
		String sql="select count(id) as num from news where  title like '%"+keyword+"%' or sub_title like '%"+keyword+"%' or author like '%"+keyword+"%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCounts=0;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCounts=rs.getInt("num");
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return totalCounts;
	}
}
