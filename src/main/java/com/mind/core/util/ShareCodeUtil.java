/**
 * 
 */
package com.mind.core.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 邀请码生成器，算法原理：<br/>
 * 1) 获取id: 1127738 <br/>
 * 2) 使用自定义进制转为：gpm6 <br/>
 * 3) 转为字符串，并在后面加'O'字符：gpm6O <br/>
 * 4）在后面随机产生若干个随机数字字符：gpm6O7 <br/>
 * 转为自定义进制后就不会出现O这个字符，然后在后面加个'O'，这样就能确定唯一性。最后在后面产生一些随机字符进行补全。<br/>
 * @author ninglong
 */
public class ShareCodeUtil {

	/** 自定义进制*/
    private static final char[] r = new char[]{'Q','1','W', 'E','0', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', '5', 'I', 'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y', 'L', 'T', 'N', '6', 'B', 'G', 'H'};

    /** (不能与自定义进制有重复) */
    private static final char b='O';

    /** 进制长度 */
    private static final int binLen = r.length;

    /** 序列最大长度 */
    private static final int s=12;

    /**
     * 根据ID生成指定随机码
     */
    public static String toSerialCode(int id) {
        char[] buf=new char[32];
        int charPos=32;
        while((id / binLen) > 0) {
            int ind=(int)(id % binLen);
            buf[--charPos]=r[ind];
            id /= binLen;
        }
        buf[--charPos]=r[(int)(id % binLen)];
        String str=new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if(str.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            Random rnd = new Random();
            for(int i=1;i < s - str.length();i++) {
            		sb.append(r[rnd.nextInt(binLen)]);
            }
            str+=sb.toString();
        }
        return str;
    }

    /**
     * 解码
     */
    public static int codeToId(String code) {
        char chs[] = code.toCharArray();
        int res = 0;
        for(int i=0; i < chs.length; i++) {
            int ind=0;
            for(int j=0; j < binLen; j++) {
                if(chs[i] == r[j]) {
                    ind=j;
                    break;
                }
            }
            if(chs[i] == b) {
                break;
            }
            if(i > 0) {
                res=res * binLen + ind;
            } else {
                res=ind;
            }
        }
        if(code.equals("DHH888")){
        	res = 2600;
		}else if(code.equals("DHH111")){
			res = 154;
		}else if(code.equals("DHH998")){
			res = 155;
		}else if(code.equals("DHH668")){
			res = 156;
		}
        return res;
    }
    
    public static void main(String[] args) {
    		Set<String> set = new HashSet<String>();
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(4399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(5399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(6399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(7399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(8399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(9399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(3399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(2399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(1399);
    			set.add(str);
    		}
    		for(int i=0;i<100000;i++){
    			String str = toSerialCode(10399);
    			set.add(str);
    		}
    		//System.out.println(set.size());
//    		System.err.println(str);
//    		long s = codeToId(str);
//    		System.err.println(s);
	}
}