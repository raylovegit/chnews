package hjj.chnews.users;

import java.util.ArrayList;
import java.util.List;

import hjj.chnews.users.UsersDAO;
import hjj.chnews.users.Users;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
	UsersDAO userdao = new UsersDAO();
@Test
public void update (){
	Users users = new Users();
	users.setId(8);
	try{
		 users=userdao.read(users);
		 users.setLoginName("loginName");
		 userdao.update(users);
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
	assertEquals("loginName",users.getLoginName());
}
@Test
public void create(){
	try{
		Users users = new Users();
		users.setLoginName("sql");
		users.setPasswords("passwords");
		users.setDes("des");
		userdao.create(users);
	}
	catch(Exception e){
		System.out.println(e);
	}
}
@Test
public void read(){
	Users users = new Users();
	users.setId(8);
	try{
		 users=userdao.read(users);
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
	assertEquals("loginName",users.getLoginName());
}
@Test
public void delete(){
	Users users = new Users();
	users.setId(4);
	try{
		userdao.delete(users);
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
}
@Test
public void bentchDetele(){
	String ids[] = new String[]{"1","2","3"};
	try{
		userdao.bentchDelete(ids);
	}
	catch(Exception exception){
		exception.printStackTrace();
	}

}
@Test
public void login(){
	try{
		Users users = new Users();
		String name="sql";
		String passwords ="passwords";
		users=userdao.login(name, passwords);
		assertEquals("des",users.getDes());
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
}
	@Test
public void queryBy(){
	List list = new ArrayList();
	String key = "" ;
	String value ="";
	boolean isAnd =false;
	try{
		list=(List)userdao.queryBy(key,value, isAnd);
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
	assertEquals(23,list.size());
}
}
