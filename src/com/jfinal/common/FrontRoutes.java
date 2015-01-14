package com.jfinal.common;

import com.btc.price.BtcController;
import com.demo.blog.BlogController;
import com.jfinal.config.Routes;
import com.jfinal.index.IndexController;
import com.touzi.user.UserController;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class, "/index");				// 第三个参数为该Controller的视图存放路径
		add("/blog", BlogController.class,"/jsp/blog");			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
		add("/user",UserController.class,"/jsp/user");
		add("/btc",BtcController.class,"/jsp/btc");
	}
	
}
