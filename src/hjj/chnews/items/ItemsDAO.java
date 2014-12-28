package hjj.chnews.items;

/**
 * @author sql
 *@version:2.0
 * @time Jul 20, 2010
 * @description:栏目名称增删查改功能实现类
 */
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

public class ItemsDAO implements BaseDao<Items> {
    
	//批量删除
	public void bentchDelete(Object[] ids) throws SQLException{
		   // TODO Auto-generated method stub
}
        
    //向数据库中插入一条记录
	public void create(Items e) throws SQLException {
		// TODO Auto-generated method stub
    	String sql ="insert into items (title) values(?)";
    	PreparedStatement pstmt=null;
    	try{
    		DBConnection dbc = new DBConnection();
    		pstmt = dbc.getConnection().prepareStatement(sql);
    		pstmt.setString(1,e.getTitle());
    		//System.out.println("pstmt。。。。。。。"+pstmt);
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
    
	//删除一条记录
	public void delete(Items e) throws SQLException {
		// TODO Auto-generated method stub
       String sql="delete  from items where id=?";
       PreparedStatement pstmt = null;
       try{
    	   DBConnection dbc = new DBConnection();
    	   pstmt = dbc.getConnection().prepareStatement(sql);
    	   pstmt.setInt(1,e.getId());
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

	public Collection<Items> queryBy(String key, String value, boolean isAnd)
			throws SQLException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String sql;
		if(key!=""&&value!="")
		sql="select * from items where  "+key+" like '%"+value+"%'";
		else
		sql="select * from items ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Items items = null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();
           while(rs.next()){
       	    items = new Items();
       	    items.setId(rs.getInt(1));
       	    items.setTitle(rs.getString(2));
            list.add(items);
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

	public Collection<Items> queryByOrder(String key, String value, boolean isAnd,
			String order, boolean isUp) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
 
	//读出一条记录
	public Items read(Items e) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from items where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Items items =null;
		try{
			DBConnection dbc= new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,e.getId());
            rs = pstmt.executeQuery();
            if(rs.next()){
            	items=new Items();
            	items.setId(rs.getInt(1));
            	items.setTitle(rs.getString(2));
            }
		}
            catch(IOException io){
         	   io.printStackTrace();
            }
            catch(Exception exception){
         	   exception.printStackTrace();
            }
		return items ;
	}

	//更新一条记录
	public void update(Items e) throws SQLException {
		// TODO Auto-generated method stub
       String sql="update items set title=? where id=?";
       PreparedStatement pstmt=null;
       try{
    	   DBConnection dbc = new DBConnection();
    	   pstmt = dbc.getConnection().prepareStatement(sql);
    	   pstmt.setString(1,e.getTitle());
    	   pstmt.setInt(2, e.getId());
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
	public Collection<Items> pageBreak(String key, String value, int size,
			int beginIndex) throws SQLException {
		String sql="";
		List list = new ArrayList();
		if (!("".equals(key))&&key!=null &&!("".equals(key))&&value!=null)
			sql = "select * from items where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select * from items ";
		sql+=" order by id desc limit ?,?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Items items=null;
		try {
			DBConnection dbc = new DBConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,beginIndex);
			pstmt.setInt(2,size);
			System.out.println("pstmt:"+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				items = new Items();
				items.setId(rs.getInt(1));
            	items.setTitle(rs.getString(2));
				list.add(items);
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
			sql = "select count(id) as num from items where  " + key + " like '%" + value
					+ "%'";
		else
			sql = "select count(id) as num from items ";
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
