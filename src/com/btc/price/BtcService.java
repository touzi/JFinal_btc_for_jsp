package com.btc.price;  

import java.io.IOException;

import com.touzi.tools.OtherTools;


/** 
 * @Title: BtcService.java 
 * @Package com.btc.price 
 * @Description: TODO(service类) 
 * @author touzi 
 * @date 2014年12月2日 下午3:53:38 
 * @version V1.0 
 */
public class BtcService {
	
	public String findBtcAll() throws IOException {
		String btcStr = null;
		String btcHuobiUrl = "http://api.huobi.com/staticmarket/ticker_btc_json.js";
		String btcOkcoinUrl = "https://www.okcoin.cn/api/v1/ticker.do?symbol=btc_cny";
		btcStr = OtherTools.urlJson(btcHuobiUrl)+","+OtherTools.urlJson(btcOkcoinUrl);
		return btcStr;
	}
}
  
