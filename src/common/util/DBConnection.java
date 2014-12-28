/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author rslee
 * @data 2010-7-5
 * 说明：这个DBConnection有如下的功能：
 * 连接数据库，取得数据库的连接，释放数据库连接
 */
public class DBConnection {

    private  MysqlConnectionPoolDataSource src ;
    public DBConnection() throws IOException{
        this.init();
    }

    private  void init() throws IOException{
        src= new MysqlConnectionPoolDataSource();
        //解析配置文件
        PropertiesParser pp = new PropertiesParser("DB.properties");
        src.setURL(pp.getValue("db.url"));
        src.setEncoding(pp.getValue("db.encoding"));
        src.setUser(pp.getValue("db.user"));
        src.setPassword(pp.getValue("db.password"));
    }

    public  Connection getConnection() throws SQLException{
        return src.getConnection();
    }

}
