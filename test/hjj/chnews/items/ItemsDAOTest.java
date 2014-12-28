package hjj.chnews.items;

/**
 * @author sql
 *@version:2.0
 * @time Jul 21, 2010
 * @description:
 * 
 */

import org.junit.Test;
import static org.junit.Assert.*;
public class ItemsDAOTest {
	ItemsDAO dao = new ItemsDAO();
	@Test
	public void create() throws Exception{
		Items items = new Items();
		items.setTitle("测试");
		dao.create(items);
		items = dao.read(items);
	}
	@Test
	public void read() throws Exception{
		Items items = new Items();
		items.setId(3);
		items = dao.read(items);
		assertEquals("item3",items.getTitle());
	}
	@Test
	public void delete() throws Exception{
		Items items = new Items();
		items.setId(2);
		items=dao.read(items);
		dao.delete(items);
	}
	@Test
	public void bentchDelete()throws Exception{
		Object ids[] = new String[]{"12","13","14","15","16","17","18"}; 
		dao.bentchDelete(ids);
	}
	@Test
	public void update()throws Exception{
		Items items = new Items();
		items.setId(5);
		items.setTitle("学院新闻");
		dao.update(items);
		assertEquals("学院新闻",items.getTitle());
	}
}
