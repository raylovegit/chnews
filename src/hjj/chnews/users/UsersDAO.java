/**
 * @author sql
 *@version:2.0
 * @time Jul 21, 2010
 * @description:
 */
package hjj.chnews.users;

import hjj.chnews.items.Items;
import hjj.chnews.news.News;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import common.util.BaseDao;
import common.util.DBConnection;

/**
 * @author sql
 *@version:2.0
 * @time Jul 21, 2010
 * @description:用户实现的具体方法
 */
public class UsersDAO implements BaseDao<Users> {
	
    
	public Users login(String loginName,String passwords) throws SQLException,IOException,Exception{
		Users users = null;
		String sql = "select * from users where loginName=? and passwords=?";
		//System.out.println("user login sql。。。。"+sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,loginName);
			pstmt.setString(2,passwords);
			System.out.println("qq"+pstmt);
			rs=pstmt.executeQuery();
			if(rs.next()){
				users = new Users();
				users.setId(rs.getInt(1));
				users.setLoginName(rs.getString(2));
				users.setPasswords(rs.getString(3));
				users.setDes(rs.getString(4));
			}
			rs.close();
			pstmt.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			throw ioe;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return users;
	}
	

	/* (non-Javadoc)
	 * @see common.util.BaseDao#bentchDelete(java.lang.Object[])
	 */
	public void bentchDelete(Object[] ids) throws SQLException {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#create(java.lang.Object)
	 */
	public void create(Users users) throws SQLException {
		// TODO Auto-generated method stub
		String sql ="insert into users (loginName,passwords,des) values(?,?,?)";
    	PreparedStatement pstmt=null;
    	try{
    		DBConnection dbc = new DBConnection();
    		pstmt = dbc.getConnection().prepareStatement(sql);
    		pstmt.setString(1,users.getLoginName());
    		pstmt.setString(2, users.getPasswords());
    		pstmt.setString(3, users.getDes());
    		System.out.println("pstmt。。。。。。。"+pstmt);
    		pstmt.executeUpdate();
    	}
    	catch(SQLException sqlException){
    		sqlException.printStackTrace();
    		throw sqlException;
    	}
    	catch(IOException io){
    		io.printStackTrace();
    	}
    	catch(Exception exception){
    		exception.printStackTrace();
    	}
	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#delete(java.lang.Object)
	 */
	public void delete(Users users) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from users where id=?";
	       PreparedStatement pstmt = null;
	       try{
	    	   DBConnection dbc = new DBConnection();
	    	   pstmt = dbc.getConnection().prepareStatement(sql);
	    	   pstmt.setInt(1,users.getId());
	    	   pstmt.executeUpdate();
	       }
	       catch(IOException io){
	    	   io.printStackTrace();
	       }
	       catch(Exception exception){
	    	   exception.printStackTrace();
	       }
	       
	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#deleteBy(java.lang.String, java.lang.String, boolean)
	 */
	public void deleteBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#queryBy(java.lang.String, java.lang.String, boolean)
	 */
	
	
	//如果查询条件不为空，返回全部记录。如果条件不为空，返回符合条件的记录
	public Collection<Users> queryBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sql;
		if(key!=""&&value!="")
		sql="select * from users where  "+key+" like '%"+value+"%'";
		else
		sql="select * from users ";
		sql+="order by id desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users =null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			//System.out.println("pstmt。。。。。。"+pstmt);
            rs = pstmt.executeQuery();
           while(rs.next()){
       	    users = new Users();
            users.setId(rs.getInt(1));
            users.setLoginName(rs.getString(2));
            users.setPasswords(rs.getString(3));
            users.setDes(rs.getString(4));
            list.add(users);
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

	/* (non-Javadoc)
	 * @see common.util.BaseDao#queryByOrder(java.lang.String, java.lang.String, boolean, java.lang.String, boolean)
	 */
	public Collection queryByOrder(String key, String value, boolean isAnd,
			String order, boolean isUp) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#read(java.lang.Object)
	 */
	public Users read(Users users) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from users where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users2 =null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,users.getId());
			//System.out.println("pstmt。。。。。。"+pstmt);
            rs = pstmt.executeQuery();
           if(rs.next()){
        	 users2 = new Users();
             users2.setId(rs.getInt(1));
             users2.setLoginName(rs.getString(2));
             users2.setPasswords(rs.getString(3));
             users2.setDes(rs.getString(4));
           }
		}
           catch(IOException io){
        	   io.printStackTrace();
           }
           catch(Exception exception){
        	   exception.printStackTrace();
           }
		return users2 ;
	}

	/* (non-Javadoc)
	 * @see common.util.BaseDao#update(java.lang.Object)
	 */
	public void update(Users users) throws SQLException {
		// TODO Auto-generated method stub
		 String sql="update users set loginName=?,passwords=?,des=? where id=?";
	       PreparedStatement pstmt=null;
	       try{
	    	   DBConnection dbc = new DBConnection();
	    	   pstmt = dbc.getConnection().prepareStatement(sql);
	    	   pstmt.setString(1,users.getLoginName());
	    	   pstmt.setString(2, users.getPasswords());
	    	   pstmt.setString(3, users.getDes());
	    	   pstmt.setInt(4, users.getId());
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


	public Collection<Users> pageBreak(String key, String value, int size,
			int beginIndex) throws SQLException {
		String sql="";
		List list = new ArrayList();
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql = "select * from users where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select * from users ";
		sql+=" order by id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users=null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			System.out.println("pstmt:"+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				users=new Users();
				 users.setId(rs.getInt(1));
	             users.setLoginName(rs.getString(2));
	             users.setPasswords(rs.getString(3));
	             users.setDes(rs.getString(4));
				list.add(users);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	//查询总记录数
	public int getCount(String key,String value){
		String sql="";
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql = "select count(id) as num from users where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select count(id) as num from users ";
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
