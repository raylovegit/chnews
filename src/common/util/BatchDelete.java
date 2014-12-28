package common.util;

import java.io.IOException;
import java.sql.PreparedStatement;

public class BatchDelete {

	public void batchDelete(Object ids[], String key,String tableName) throws IOException ,Exception{
		String keyword = "";
		//把数组转化成字符串
		if(ids!=null&&ids.length>0){
		for(int i=0;i<ids.length-1;i++)
			keyword+="'"+ids[i]+"' ,";
		    keyword+="'"+ids[ids.length-1]+"'";
		    //System.out.println("keyword。。。。。。"+keyword);
		    
		    //执行批量删除
		    String sql ="delete from "+tableName+" where "+key+" in ("+keyword+")" ;
		    PreparedStatement pstmt = null;
		    try{
		    	DBConnection dbc = new DBConnection();
		    	pstmt = dbc.getConnection().prepareStatement(sql);
		    	System.out.println("pstmt。。。。。"+pstmt);
		    	pstmt.executeUpdate();
		    }
		    catch(IOException ioe){
		    	ioe.printStackTrace();
		    	throw ioe;
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    	throw e;
		    }
		}
	}
	
}
