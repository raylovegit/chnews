/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author rslee
 * @data 2010-6-8
 * 说明：这个PropertiesParser有如下的功能：
 * 负责解析properties文件
 */
public class PropertiesParser {

    private Properties p;
    public PropertiesParser() throws IOException{
    }
    public PropertiesParser(String propertiesName) throws IOException{
        InputStream in = PropertiesParser.class.getClassLoader().getResourceAsStream(propertiesName);
        p = new Properties();
        p.load(in);
    }
    //获取某一个键的值
    public String getValue(String key){
        return p.getProperty(key);
    }

}
