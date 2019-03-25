package com.xue.oas.utils;

public class OAutils {
	public static Long[] convertLongs(String[] str){
		Long[] l = new Long[str.length];
		int index = 0;
		for(String s : str){
			l[index] = Long.parseLong(s);
			index++;
		}
		return l;
	}
}
