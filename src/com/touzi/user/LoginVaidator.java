package com.touzi.user;  

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/** 
 * @Title: LoginVaidator.java 
 * @Package com.touzi.user 
 * @Description: TODO(验证用户登录) 
 * @author touzi 
 * @date 2014年11月11日 下午2:36:37 
 * @version V1.0 
 */
public class LoginVaidator extends Validator {

	protected void validate(Controller c) {
		validateRequired("userName", "userNameMsg", "用户名不能为空.");
		validateRequired("passWord", "passWordMsg", "密码不能为空.");
	}

	protected void handleError(Controller c) {
		c.keepPara("userName","passWord");
		c.render("/jsp/login/login.jsp");
	}

}
  
