/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import hjj.chnews.items.Items;

import java.io.IOException;
import java.sql.PreparedStatement;

import org.junit.Test;


/**
 *
 * @author rslee
 * @data 2010-7-9
 * 说明：这个DBConnectionTest有如下的功能：
 */
public class DBConnectionTest {

    @Test
    public void init()throws IOException{
        new DBConnection();
    }
   

}
