package com.touzi.user;  

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;
import com.touzi.interceptor.LoginInterceptor;
import com.touzi.log.Log;

/** 
 * @Title: UserController.java 
 * @Package com.touzi.user 
 * @Description: TODO(添加描述) 
 * @author touzi 
 * @date 2014年11月10日 下午1:00:41 
 * @version V1.0 
 */
@Before(LoginInterceptor.class)
public class UserController extends Controller {
	
	public void index() {
		setAttr("userList", User.me.findAll());
		render("user.jsp");
	}
	
	@ClearInterceptor
	public void signin() {
		render("/jsp/login/login.jsp");
	}
	
	@ClearInterceptor
	@Before(LoginVaidator.class)
	public void login() {
		String userName = getPara("userName");
		String passWord = getPara("passWord");
		User user = User.me.getUserNameAndPassWord(userName, passWord);
		if(user != null) {
			//String userInfo = user.getStr("id") +","+user.getStr("userName");//需要什么都可以继续存储		---touzi
			//setCookie("userInfo", userInfo, 3600*24*30);
			setSessionAttr("users", user);
			redirect(getPara("goto"));
			Log.logInfo(this.getSessionAttr("users"), getRequest(), "用户登录");
		}else {
			setAttr("userName", userName);
			setAttr("passWord", passWord);
			setAttr("msg", "用户名或密码错误:(");
			render("/jsp/login/login.jsp");
			Log.logInfo(this.getSessionAttr("users"), getRequest(), userName+"->登录失败");
		}
	}
	
	
	/**
	 * @author touzi
	 * TODO 清空session和cookie
	 */
	public void logout() {
		Log.logInfo(this.getSessionAttr("users"), getRequest(), "用户退出");
		removeSessionAttr("users");
		//removeCookie("userInfo");
		redirect("/");
	}
	
	@ClearInterceptor
	public void add() {}
	
	@Before(UserValidator.class)
	public void save() {
		User user = getModel(User.class);
		user.mySave();
		
		Log.logInfo(this.getSessionAttr("users"), getRequest(), "注册用户");
		redirect("/user");
	}
	
	public void delete() {
		User.me.deleteById(getParaToInt());
		Log.logInfo(this.getSessionAttr("users"), getRequest(), "删除用户->"+getParaToInt());
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.me.findById(getParaToInt()));
		Log.logInfo(this.getSessionAttr("users"), getRequest(), "编辑用户->"+getParaToInt());
	}
	
	/**
	 * 这里不能使用验证了,因为验证会提示用户名和有限已经注册
	 * @author touzi 
	 */
	public void update() {
		User user = getModel(User.class);
		user.myUpdate();
		Log.logInfo(this.getSessionAttr("users"), getRequest(), "更新用户->"+user.getInt("id"));
		redirect("/user");
	}
}
  
