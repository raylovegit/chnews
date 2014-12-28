/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common.util;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author rslee
 * @data 2010-7-5
 * 说明：这个BaseDao有如下的功能：
 * 定义常见的数据库操作的接口
 * 1.CRUD
 * 2.按照条件查询
 * 3.按照条件排序
 */
public interface BaseDao<E> {

    public void create(E e)throws SQLException;

    public void delete(E e)throws SQLException;

    public void update(E e)throws SQLException;

    public E read(E e)throws SQLException;

    public Collection<E> queryBy(String key,String value,boolean isAnd)throws SQLException;

    public Collection<E> queryByOrder(String key,String value,boolean isAnd
            ,String order,boolean isUp)throws SQLException;

    public void deleteBy(String key,String value,boolean isAnd)throws SQLException;

    public void bentchDelete(Object [] ids)throws SQLException;
    
    //分页方法
    public Collection<E> pageBreak(String key,String value,int size,int beginIndex) throws SQLException;

}
