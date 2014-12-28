/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rslee
 * @data 2010-7-9
 * 说明：这个PropertiesParserTest有如下的功能：
 * 测试PropertiesParser是否可以读取指定的properties文件
 */
public class PropertiesParserTest {

    @Test
    public void init() throws IOException{
        assertNotNull(new PropertiesParser("DB.properties"));
    }
    @Test
    public void getValue() throws IOException{
        PropertiesParser pp=new PropertiesParser("DB.properties");
        assertEquals("jdbc:mysql://localhost:3306/chnews",pp.getValue("db.url"));
        assertEquals("utf-8",pp.getValue("db.encoding"));
        assertEquals("root",pp.getValue("db.user"));
        assertEquals("hjj",pp.getValue("db.password"));
    }
    
}
