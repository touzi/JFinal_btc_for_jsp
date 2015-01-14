package com.touzi.user;  

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.DateTools;
import com.touzi.tools.OtherTools;

/** 
 * @Title: User.java 
 * @Package com.touzi.user 
 * @Description: TODO(用户表实体类) 
 * @author touzi 
 * @date 2014年11月10日 上午10:25:15 
 * @version V1.0 
 
 mysql> describe user;
+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| id            | int(11)      | NO   | PRI | NULL    | auto_increment |
| userName      | varchar(200) | NO   |     | NULL    |                |
| userPass      | varchar(200) | NO   |     | NULL    |                |
| nickName      | varchar(200) | NO   |     | NULL    |                |
| userState     | varchar(200) | NO   |     | NULL    |                |
| userInfo      | varchar(200) | YES  |     | NULL    |                |
| userEnabled   | int(2)       | YES  |     | NULL    |                |
| registerEmail | varchar(100) | NO   |     | NULL    |                |
| registerDate  | varchar(22)  | NO   |     | NULL    |                |
| alterDate     | varchar(22)  | YES  |     | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	public static final User me = new User();
	
	public List<User> findAll() {
		return find("select * from user order by id desc");
	}
	
	public void mySave() {
		String pw = OtherTools.getMD5(this.getStr("userPass").getBytes());
		this.set("userPass", pw).set("userState", "zh-CN").set("registerDate", DateTools.getCurrentDate());
		this.save();
	}
	
	public void myUpdate() {
		String pw = OtherTools.getMD5(this.getStr("userPass").getBytes());
		this.set("userPass", pw).set("alterDate", DateTools.getCurrentDate());
		this.update();
	}
	
	/**
	 * 判断登录
	 */
	public User getUserNameAndPassWord(String userName, String passWord) {
		String pwd = OtherTools.getMD5(passWord.getBytes());
		return findFirst("select * from user where userName = ? and userPass = ? ",userName,pwd);
	}
	
	/**
	 * 验证email是否可用
	 */
	public boolean containEmail(String email) {
		return me.findFirst("select registerEmail from user where registerEmail = ? limit 1 ",email) != null;
	}
	
	/**
	 * 验证用户名是否可用
	 */
	public boolean containUser(String userName) {
		return me.findFirst("select userName from user where userName = ? limit 1 ",userName) != null;
	}
}
  
