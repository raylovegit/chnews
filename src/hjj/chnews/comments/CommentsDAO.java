package hjj.chnews.comments;

import hjj.chnews.items.Items;
import hjj.chnews.users.Users;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import common.util.BaseDao;
import common.util.DBConnection;

public class CommentsDAO implements BaseDao<Comments> {

	/* (non-Javadoc)
	 * @see common.util.BaseDao#read(java.lang.Object)
	 */
	public Comments read(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from comments where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1,comments.getId());
            rs = pstmt.executeQuery();
           if(rs.next()){
        	   comments.setId(rs.getLong(1));
        	   comments.setNewsId(rs.getLong(2));
        	   comments.setAuthor(rs.getString(3));
        	   comments.setContent(rs.getString(4));
           }
		}
           catch(IOException io){
        	   io.printStackTrace();
           }
           catch(Exception exception){
        	   exception.printStackTrace();
           }
		return comments;
	}

	public void bentchDelete(Object[] ids) throws SQLException {
		// TODO Auto-generated method stub
	}

	public void create(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="insert into comments (newsId,author,content,time) values(?,?,?,?)";
    	PreparedStatement pstmt=null;
    	try{
    		DBConnection dbc = new DBConnection();
    		pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setLong(1,comments.getNewsId());
            pstmt.setString(2,comments.getAuthor());
            pstmt.setString(3, comments.getContent());
            pstmt.setString(4,comments.getTime());
            pstmt.executeUpdate();
    	}
    	catch(SQLException sqlException){
    		throw sqlException;
    	}
    	catch(IOException io){
    		io.printStackTrace();
    	}
    	catch(Exception exception){
    		exception.printStackTrace();
    	}
	}

	public void delete(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		   String sql="delete  from comments where id=?";
	       PreparedStatement pstmt = null;
	       try{
	    	   DBConnection dbc = new DBConnection();
	    	   pstmt = dbc.getConnection().prepareStatement(sql);
	    	   pstmt.setLong(1,comments.getId());
	    	   pstmt.executeUpdate();
	       }
	       catch(IOException io){
	    	   io.printStackTrace();
	       }
	       catch(Exception exception){
	    	   exception.printStackTrace();
	       }
	}

	public void deleteBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<Comments> queryBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sql;
		if(key!=""&&value!="")
		sql="select * from comments where  "+key+" like '%"+value+"%'";
		else
		sql="select * from comments ";
		sql+="order by id desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comments comments = null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
           while(rs.next()){
        	   comments = new Comments();
        	   comments.setId(rs.getLong(1));
        	   comments.setNewsId(rs.getLong(2));
        	   comments.setAuthor(rs.getString(3));
        	   comments.setContent(rs.getString(4));
            list.add(comments);
          }
		}
          catch(IOException io){
       	   io.printStackTrace();
          }
          catch(Exception exception){
       	   exception.printStackTrace();
          }
		return list;
	}
	
	//按新闻	Id查询全部评论
	public Collection<Comments> query(long newsId){
		List list = new ArrayList();
		String sql="select * from comments where newsId ="+newsId;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comments comments = null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
           while(rs.next()){
        	   comments = new Comments();
        	   comments.setId(rs.getLong(1));
        	   comments.setNewsId(rs.getLong(2));
        	   comments.setAuthor(rs.getString(3));
        	   comments.setContent(rs.getString(4));
        	   comments.setFlag(rs.getString(5));
        	   comments.setTime(rs.getString(6));
               list.add(comments);
          }
		}
          catch(IOException io){
       	   io.printStackTrace();
          }
          catch(Exception exception){
       	   exception.printStackTrace();
          }
          System.out.println("clist"+list.size());
		return list;
	}

	public Collection<Comments> queryByOrder(String key, String value, boolean isAnd,
			String order, boolean isUp) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void update(Comments comments) throws SQLException {
		// TODO Auto-generated method stub
		   String sql="update comments set author=?,content=? where id=?";
	       PreparedStatement pstmt=null;
	       try{
	    	   DBConnection dbc = new DBConnection();
	    	   pstmt = dbc.getConnection().prepareStatement(sql);
	    	   pstmt.setString(1,comments.getAuthor());
	    	   pstmt.setString(2,comments.getContent());
	    	   pstmt.setLong(3,comments.getId());
	    	   //System.out.println("pstmt。。。。。"+pstmt);
	    	   pstmt.executeUpdate();
	       }
	       catch(SQLException sqlException){
	    	  throw sqlException;
	       }
	       catch(IOException io){
	    	   io.printStackTrace();
	       }
	       catch(Exception exception){
	    	   exception.printStackTrace();
	       }
	}

	public Collection<Comments> pageBreak(String key, String value, int size,
			int beginIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//按新闻	Id查询显示或者不显示评论
	public Collection<Comments> queryShow(long newsId,String flag){
		List list = new ArrayList();
		String sql="select author,content,time from comments where flag=? and newsId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comments comments = null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,flag);
			pstmt.setLong(2,newsId);
			System.out.println("comments：pstmt"+pstmt);
            rs = pstmt.executeQuery();
           while(rs.next()){
        	   comments = new Comments();
        	   comments.setAuthor(rs.getString(1));
        	   comments.setContent(rs.getString(2));
        	   comments.setTime(rs.getString(3));
               list.add(comments);
          }
		}
          catch(IOException io){
       	   io.printStackTrace();
          }
          catch(Exception exception){
       	   exception.printStackTrace();
          }
          System.out.println("clist"+list.size());
		return list;
	}
	
	//更新评论是否显示
	public void update(long id) throws SQLException {
		// TODO Auto-generated method stub
		   String sql="update comments set flag=? where id=?";
	       PreparedStatement pstmt=null;
	       try{
	    	   DBConnection dbc = new DBConnection();
	    	   pstmt = dbc.getConnection().prepareStatement(sql);
	    	   pstmt.setString(1,"true");
	    	   pstmt.setLong(2,id);
	    	   System.out.println("pstmt。。。。。"+pstmt);
	    	   pstmt.executeUpdate();
	       }
	       catch(SQLException sqlException){
	    	  throw sqlException;
	       }
	       catch(IOException io){
	    	   io.printStackTrace();
	       }
	       catch(Exception exception){
	    	   exception.printStackTrace();
	       }
	}

}
