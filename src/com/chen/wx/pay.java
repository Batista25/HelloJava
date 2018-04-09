package com.chen.wx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class pay {

	public static void main(String[] args) {
		String appid = "wx082585a0b053bf95";
		String mch_id = "1330394301";
		String nonce_str = getRandomStringByLength(10);
		String body = "BOE测试";
		String out_trade_no = "20170726001";
		int total_fee = 1;
		String spbill_create_ip = "127.0.0.1";
		String notify_url = "1";
		String trade_type = "NATIVE";		
		Map para = new HashMap<String, Object>();
		para.put("appid", appid);
		para.put("mch_id", mch_id);
		para.put("nonce_str", nonce_str);
		para.put("body", body);
		para.put("out_trade_no", out_trade_no);
		para.put("total_fee", total_fee);
		para.put("spbill_create_ip", spbill_create_ip);
		para.put("out_trade_no", out_trade_no);
		para.put("notify_url", notify_url);
		para.put("trade_type", trade_type);
		String sign = getSign(para);

	}
	/**
	 * 生成随机数
	 * @param length
	 * @return
	 */
	public static String getRandomStringByLength(int length) {  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < length; i++) {  
            int number = random.nextInt(base.length());  
            sb.append(base.charAt(number));  
        }  
        return sb.toString();  
    }  
	/**
	 * 生成签名
	 * @param map
	 * @return
	 */
	public static String getSign(Map<String,Object> map){  
        ArrayList<String> list = new ArrayList<String>();  
        for(Map.Entry<String,Object> entry:map.entrySet()){  
            if(entry.getValue()!=""){  
                list.add(entry.getKey() + "=" + entry.getValue() + "&");  
            }  
        }  
        int size = list.size();  
        String [] arrayToSort = list.toArray(new String[size]);  
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);  
        StringBuilder sb = new StringBuilder();  
        for(int i = 0; i < size; i ++) {  
            sb.append(arrayToSort[i]);  
        }  
        String result = sb.toString();  
        result += "key=" + "R2mAcp8Esr2SLSdj8antC69SW4QvKGsZ0tnnZCFeDku";  
        //Util.log("Sign Before MD5:" + result);  
        result = MD5.MD5Encode(result).toUpperCase();  
        //Util.log("Sign Result:" + result);  
        return result;  
    }  
	

}
