package com.touzi.log;  

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.plugin.activerecord.Model;
import com.touzi.tools.DateTools;
import com.touzi.tools.GetIP4;
import com.touzi.user.User;

/** 
 * @Title: Log.java 
 * @Package com.touzi.log 
 * @Description: TODO(添加描述) 
 * @author touzi 
 * @date 2014年11月27日 下午1:58:56 
 * @version V1.0 
 * 
 * mysql> describe log;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int(11)      | NO   | PRI | NULL    | auto_increment |
| ip          | varchar(128) | YES  |     | NULL    |                |
| userId      | int(11)      | NO   |     | NULL    |                |
| userName    | varchar(200) | NO   |     | NULL    |                |
| logDateTime | varchar(22)  | NO   |     | NULL    |                |
| logInfo     | varchar(500) | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
 */
@SuppressWarnings("serial")
public class Log extends Model<Log> {
	
	public static final Log me = new Log();
	
	public List<Log> findAll() {
		return find("select * from log order by id desc ");
	}
	
	public static void logInfo(Object users, HttpServletRequest request, String info) {
		String ip = GetIP4.getIpAddr(request);
		if(users != null){
			User user = (User) users;
			me.set("ip", ip).set("userId", user.getInt("id")).set("userName", user.getStr("userName")).set("logDateTime", DateTools.getCurrentDate()).set("logInfo", info);
			me.save();
			me.clear();
		}else {
			me.set("ip", ip).set("userId", 0).set("userName", "error").set("logDateTime", DateTools.getCurrentDate()).set("logInfo", info);
			me.save();
			me.clear();
		}
	}
}
  
