package com.btc.price;  

import java.io.IOException;

import com.jfinal.core.Controller;

/** 
 * @Title: BtcController.java 
 * @Package com.btc.price 
 * @Description: TODO(btc) 
 * @author touzi 
 * @date 2014年12月2日 下午3:47:41 
 * @version V1.0 
 */
public class BtcController extends Controller {
	
	public void index() throws IOException {
		BtcService bs = new BtcService();
		String json = bs.findBtcAll();
		System.out.println("json>"+json);
		renderJson("btcJson", json);
	}
}
  
