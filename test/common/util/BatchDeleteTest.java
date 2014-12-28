/**
 * @author sql
 *@version:2.0
 * @time Jul 26, 2010
 * @description:
 */
package common.util;

import java.io.IOException;
import java.sql.PreparedStatement;

import org.junit.Test;

/**
 * @author sql
 *@version:2.0
 * @time Jul 26, 2010
 * @description: 批量删除测试
 */
public class BatchDeleteTest {
    BatchDelete batchDe = new BatchDelete();
@Test
public void batchDelete(){
	String ids[] = new String[]{"1","2","3","4"};
	String tableName ="items";
	String key ="id";
	try{
	batchDe.batchDelete(ids,key,tableName);}
	catch(Exception e){
		System.out.println("exception。。。。。"+e);
	}
}
}
