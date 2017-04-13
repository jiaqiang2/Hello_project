package com.hello.util;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RandomUtil {
	
	private static Logger logger = LoggerFactory.getLogger(RandomUtil.class);
	
	/**
	 * 获取数字随机数
	 * @param count  随机数的位数,最多10位
	 * @return
	 */
	public static String getRandomNum(int count){
		String[] strs = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		//将strs数组存入list  注：Integer[]能达到同样效果   坑：int[]是将整个数组作为一个元素存入list
		List<String> list = Arrays.asList(strs);
		//打乱集合中元素的顺序
		Collections.shuffle(list);
		StringBuffer sBuffer = new StringBuffer();
		for (String string : list) {
			sBuffer.append(string);
		}
		String str = sBuffer.toString().substring(0, count);
		logger.info("数字组合的随机数："+str);
		return str;
	}
	
	/**
	 * 获取字母组合的随机数
	 * @param count  随机数位数
	 * @return
	 */
	public static String getRandomStr(int count){
		String nonce_str = "";
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
          'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
          'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' ,
          'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
          'x', 'y', 'z'};
		
		for(int i = 0; i<count; i++){
			nonce_str += codeSequence[(int) (Math.random() * codeSequence.length)];
		}
		logger.info("字母组合的随机数："+nonce_str);
		return nonce_str;
	}
	
	public static void main(String[] args) {
		getRandomStr(5);
	}
}
