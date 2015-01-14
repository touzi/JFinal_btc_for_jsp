package com.touzi.user;  

import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;
import com.jfinal.validate.Validator;

/** 
 * @Title: UserValidator.java 
 * @Package com.touzi.user 
 * @Description: TODO(user验证) 
 * @author touzi 
 * @date 2014年11月10日 下午5:01:43 
 * @version V1.0 
 */
public class UserValidator extends Validator {

	protected void validate(Controller c) {
		validateEmail("user.registerEmail", "registerEmailMsg", "邮箱不正确.");
		validateRegex("user.userName", "[a-zA-Z0-9_]{2,8}", "userNameMsg", "用户名的长度介于2-8之间,只能包含数字,字母,下划线");
		validateRegex("user.userPass", "^[a-zA-Z]\\w{5,17}$", "userPassWordMsg", "以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
		validateEqualField("user.userPass", "rePassWord", "rePassWordMsg", "2次输入的密码不一致.");
		String email = c.getPara("user.registerEmail");
		if(StringKit.notBlank(email) && User.me.containEmail(email)) {
			addError("registerEmailMsg", "邮箱已经被注册过了:( ");
		}
		String userName = c.getPara("user.userName");
		if(StringKit.notBlank(userName) && User.me.containUser(userName)) {
			addError("userNameMsg", "用户名已经被注册过了:( ");
		}
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(User.class);
		c.render("/jsp/user/add.jsp");
	}

}
  
