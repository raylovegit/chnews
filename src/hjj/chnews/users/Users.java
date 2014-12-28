package hjj.chnews.users;
/**
 * @author sql
 *@version:2.0
 * @time Jul 21, 2010
 * @description:用户实体类，描述用户的属性
 */
public class Users {
private int id ;
private String loginName;
private String passwords;
private String des;

//构造方法
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the loginName
 */
public String getLoginName() {
	return loginName;
}
/**
 * @param loginName the loginName to set
 */
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
/**
 * @return the passwords
 */
public String getPasswords() {
	return passwords;
}
/**
 * @param passwords the passwords to set
 */
public void setPasswords(String passwords) {
	this.passwords = passwords;
}
/**
 * @return the des
 */
public String getDes() {
	return des;
}
/**
 * @param des the des to set
 */
public void setDes(String des) {
	this.des = des;
}



}
