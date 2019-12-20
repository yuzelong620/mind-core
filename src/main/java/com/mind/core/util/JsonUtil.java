package com.mind.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field; 
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil { 
	 
	public static <T> List<T> parseJsonArray(String jsonFile ) {
		try {
		    String className=jsonFile.substring(0, jsonFile.lastIndexOf("."));
			className="com.globalgame.auto.json."+className+"_Json";
			Class<T> class1=(Class<T>) Class.forName(className);
			 
			return parseJsonArray(jsonFile,class1);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		 
	}
	public static <T> List<T> parseJsonArray(String jsonFile,Class<T> class1) {
		try {
		List result=null;
		JSONArray jsonArray=getConfigFile(jsonFile); 
		result=new ArrayList<T>();
		Field[]  fields=	class1.getDeclaredFields();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject obj=jsonArray.getJSONObject(i);
			T t=	class1.newInstance();
			for(Field field:fields){
				String fieldName=field.getName();
				if(obj.containsKey(fieldName)){
					Method method=	class1.getDeclaredMethod("set"+StringUtils.toUpperCaseFirstOne(fieldName), field.getType());
					if(field.getType() == String.class){
						method.invoke(t, obj.getString(fieldName));
					}else if(field.getType() == Integer.TYPE || field.getType() == Integer.class){
						method.invoke(t, obj.getIntValue(fieldName));
					}else if(field.getType() == Short.TYPE || field.getType() == Short.class){
						method.invoke(t, obj.getIntValue(fieldName));
					}else if(field.getType() == Byte.TYPE || field.getType() == Byte.class){
						method.invoke(t, obj.getIntValue(fieldName));
					}else if(field.getType() == Long.TYPE || field.getType() == Long.class){
						method.invoke(t, obj.getLongValue(fieldName));
					}else if(field.getType() == Float.TYPE || field.getType() == Float.class){
						method.invoke(t, obj.getDoubleValue(fieldName));
					}else if(field.getType() == Double.TYPE || field.getType() == Double.class){
						method.invoke(t, obj.getDoubleValue(fieldName));
					}else if(field.getType() == Boolean.TYPE || field.getType() == Boolean.class){
						method.invoke(t, obj.getBooleanValue(fieldName));
					}else if(field.getType()==StringIntTuple.class){
						StringIntTuple intTuple=parseStringIntTuple(obj.getJSONObject(fieldName));
						method.invoke(t, intTuple);
					}else if(field.getType()==ThreeTuple.class){
						ThreeTuple threeTuple=parseThreeTuple(obj.getJSONObject(fieldName));
						method.invoke(t, threeTuple);
					}else if(field.getType() == StringFloatTuple.class){
						StringFloatTuple stringFloatTuple=parseStringFloatTuple(obj.getJSONObject(fieldName));
						method.invoke(t, stringFloatTuple);
					}else if(field.getType() == List.class){
						JSONArray array=obj.getJSONArray(fieldName);
						List list=null;
						if(field.getGenericType().toString().equals("java.util.List<java.lang.String>")){
							list=new ArrayList<String>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(array.getString(m));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<com.mind.core.util.ThreeTuple>")){
							list=new ArrayList<ThreeTuple>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(parseThreeTuple(array.getJSONObject(m)));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<com.mind.core.util.StringFloatTuple>")){
							list=new ArrayList<StringFloatTuple>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(parseStringFloatTuple(array.getJSONObject(m)));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<com.mind.core.util.StringIntTuple>")){
							list=new ArrayList<StringIntTuple>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(parseStringIntTuple(array.getJSONObject(m)));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<com.mind.core.util.IntDoubleTuple>")){
							list=new ArrayList<IntDoubleTuple>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(parseIntDoubleTuple(array.getJSONObject(m)));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<com.mind.core.util.IntTuple>")){
							list=new ArrayList<IntTuple>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(parseIntIntTuple(array.getJSONObject(m)));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<java.lang.Integer>")){
							list=new ArrayList<Integer>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(array.getIntValue(m));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<java.lang.Integer>")){
							list=new ArrayList<Integer>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(array.getIntValue(m));
							}
						}else if(field.getGenericType().toString().equals("java.util.List<java.lang.Double>")){
							list=new ArrayList<Double>(array.size());
							for(int m=0;m<array.size();m++){
								list.add(array.getDoubleValue(m));
							}
						}
						method.invoke(t, list);
					}
				}
			}
			result.add(t);
		}
		return result;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static StringIntTuple parseStringIntTuple(JSONObject jsonObject){
		StringIntTuple intTuple=new StringIntTuple(jsonObject.getString("key"), jsonObject.getIntValue("value"));
		return intTuple;
	}
	private static StringFloatTuple parseStringFloatTuple(JSONObject jsonObject){
		StringFloatTuple stringFloat=new StringFloatTuple(jsonObject.getString("key"), jsonObject.getFloatValue("value"));
		return stringFloat;
	}
	private static ThreeTuple parseThreeTuple(JSONObject jsonObject){
		ThreeTuple threeTuple=new ThreeTuple(jsonObject.getString("key"), jsonObject.getIntValue("value"),jsonObject.getIntValue("probability"));
		return threeTuple;
	}
	private static IntDoubleTuple parseIntDoubleTuple(JSONObject jsonObject){
		IntDoubleTuple intTuple=new IntDoubleTuple(jsonObject.getIntValue("key"), jsonObject.getDoubleValue("value"));
		return intTuple;
	}
	private static IntTuple parseIntIntTuple(JSONObject jsonObject){
		IntTuple intTuple=new IntTuple(jsonObject.getIntValue("key"), jsonObject.getIntValue("value"));
		return intTuple;
	}
	
	private static String jsonPath;
	/**
	 * 设置json配置的路径
	 * @param jsonPath
	 */
	public static void setJsonPath(String jsonPath) {
		JsonUtil.jsonPath = jsonPath;
	}
	/**
	 * 获得json 配置目录
	 * @return
	 */
	private static String getJsonPath(){
		if(jsonPath==null){			
			jsonPath="json/";
		}
		return jsonPath;
	}
	private static JSONArray getConfigFile(String jsonFile) throws IOException {
		JSONArray result = null;
		File file=new File(getJsonPath()+jsonFile);
		Reader reader=null;
		if(file.exists()){
			FileInputStream  fileStream =new FileInputStream(file);//读取外部目录文件
		    reader=new InputStreamReader(fileStream,"utf-8");
		}
		else{
			reader = new InputStreamReader(JsonUtil.class.getClass().getResourceAsStream("/json/"+jsonFile),"utf-8");          
	   }
//		Reader f = new InputStreamReader(JsonUtil.class.getClass().getResourceAsStream("/json/"+jsonFile),"utf-8");          
	    BufferedReader fb = new BufferedReader(reader);  
	    StringBuffer sb = new StringBuffer("");  
	    String s = "";  
	    while((s = fb.readLine()) != null) {  
	        sb = sb.append(s);  
	    }  
		try {
			result = JSONArray.parseArray(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to read file " + jsonFile);
		}
		return result;
	}
}
