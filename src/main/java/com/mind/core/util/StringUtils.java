package com.mind.core.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
	/**
	 * 首字母转小写
	 */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0))){
            return s;
    		}else{
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    		}
    }
    /**根据字符串获取字符串的ascii
     * @param str
     * @return
     */
    public static String parseAscii(String str){
        StringBuilder sb=new StringBuilder();
        	char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
        		sb.append((int)chars[i]);
        }
        return sb.toString();
    }
	/**
	 * 首字母转大写
	 *
	 * @param s
	 * @return
	 */
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0))){
            return s;
        }else{
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

	public static String[] getStringList(String str) {
		str = trim(str);
		if (str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		String sep = ",";
		if (str.indexOf(':') >= 0) {
			sep = ":";
		}
		return str.split(sep);
	}

	public static String[] getStringList(String str, String sep) {
		str = trim(str);
		return str.split(sep);
	}

	public static int[] getIntArray(String str, String sep) {
		String[] prop = getStringList(str, sep);
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < prop.length; i++) {
			try {
				int r = Integer.parseInt(prop[i]);
				tmp.add(r);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		int[] ints = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			ints[i] = tmp.get(i);
		}
		return ints;
	}

	public static List<Integer> getIntList(String str, String sep) {
		String[] prop = getStringList(str, sep);
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < prop.length; i++) {
			try {
				int r = Integer.parseInt(prop[i]);
				tmp.add(r);
			} catch (Exception e) {
			}
		}
		return tmp;
	}

	public static String join(String[] strs, String sep) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			buffer.append(sep).append(strs[i]);
		}
		return buffer.toString();
	}

	public static double[] getDoubleList(String str) {
		String[] prop = getStringList(str);
		double[] ds = new double[prop.length];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = Double.parseDouble(prop[i]);
		}
		return ds;
	}

	public static List<String> getListBySplit(String str, String split) {
		List<String> list = new ArrayList<String>();
		if (str == null || str.trim().equalsIgnoreCase(""))
			return null;
		String[] strs = str.split(split);
		for (String temp : strs) {
			if (temp != null && !temp.trim().equalsIgnoreCase("")) {
				list.add(temp.trim());
			}
		}
		return list;
	}

	public static int[] getIntList(String str) {
		String[] prop = getStringList(str);
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < prop.length; i++) {
			try {
				String sInt = prop[i].trim();
				if (sInt.length() < 20) {
					int r = Integer.parseInt(prop[i].trim());
					tmp.add(r);
				}
			} catch (Exception e) {
			}
		}
		int[] ints = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			ints[i] = tmp.get(i);
		}
		return ints;

	}

	/**
	 * 将123|456|789形式的字符串转换为Set<Integer>
	 */
	public static Set<Integer> toIntSet(String str) {
		Set<Integer> ints = new HashSet<Integer>();
		if(isNotEmpty(str)){
			for(String intStr : str.split(CoreConstants.ELEMENT_SPLITER)){
				ints.add(Integer.parseInt(intStr));
			}
		}
		return ints;
	}
	/**
	 * 将<key,value><key,value>形式的字符串转为List<IntTuple>
	 */
	public static List<IntTuple> toIntTupleList(String str) {
		List<IntTuple> tuples =new ArrayList<>();
		if(isNotEmpty(str)){
			for(String pair : str.split(CoreConstants.GROUP_SPLITER)){
				tuples.add(toIntTuple(pair));
			}
		}
		return tuples;
	}
	/**
	 * 将<key,value><key,value>形式的字符串转为List<IntTuple>
	 */
	public static List<IntDoubleTuple> toIntDoubleTupleList(String str) {
		List<IntDoubleTuple> tuples =new ArrayList<>();
		if(isNotEmpty(str)){
			for(String pair : str.split(CoreConstants.GROUP_SPLITER)){
				tuples.add(toIntDoubleTuple(pair));
			}
		}
		return tuples;
	}
	/**
	 * 将<key,value><key,value>形式的字符串转为List<IntTuple>
	 */
	public static List<StringIntTuple> toStringIntTupleList(String str) {
		List<StringIntTuple> tuples =new ArrayList<>();
		if(isNotEmpty(str)){
			for(String pair : str.split(CoreConstants.GROUP_SPLITER)){
				tuples.add(toStringIntTuple(pair));
			}
		}
		return tuples;
	}
	/**
	 * 将<key|value>形式的字符串转为IntTuple
	 */
	public static IntTuple toIntTuple(String str) {
		if(isEmpty(str)){
			return null;
		}
		int key = Integer.parseInt(str.substring(1,str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR)));
		int value = Integer.parseInt(str.substring(str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR)+1, str.length() -1));
		return new IntTuple(key, value);
		
	}
	
	/**
	 * 将<key,value>形式的字符串转为IntTuple
	 */
	public static IntDoubleTuple toIntDoubleTuple(String str) {
		if(isEmpty(str)){
			return null;
		}
		int key = Integer.parseInt(str.substring(1,str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR)));
		double value =Double.parseDouble(str.substring(str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR)+1, str.length() -1));
		return new IntDoubleTuple(key, value);
		
	}
	/**
	 * 将<key,value>形式的字符串转为IntTuple
	 */
	public static StringIntTuple toStringIntTuple(String str) {
		if(isEmpty(str)){
			return null;
		}
		String key = str.substring(1,str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR));
		int value =Integer.parseInt(str.substring(str.indexOf(CoreConstants.ELEMENT_SPLITER_CHAR)+1, str.length() -1));
		return new StringIntTuple(key, value);
	}
}
