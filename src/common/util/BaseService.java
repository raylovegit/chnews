/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

/**
 *
 * @author rslee
 * @data 2010-7-5
 * 说明：这个BaseServlet有如下的功能：
 * 定义service的一下常见的操作
 */
public interface BaseService {
    public void preCreate() throws Exception;
    //创建单个实体
    public void create() throws Exception;
    //删除一个或者多个实体
    public void delete() throws Exception;
    
    public void preUdate() throws Exception;
    //更新单个实体
    public void update() throws Exception;
    //查询单个实体
    public void read()throws Exception;
    //查询所有实体
    public void list()throws Exception;
    //批量删除实体
    public void bentchDelete() throws Exception;
    //条件查询
    public void query() throws Exception;
    //唯一性验证
    public void isUnique() throws Exception;

}
