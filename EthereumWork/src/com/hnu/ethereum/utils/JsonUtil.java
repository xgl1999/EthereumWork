package com.hnu.ethereum.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 
 * @author huangqiang
 * @content 框架统一工具类
 * 
 */
public class JsonUtil {

	/**
	 * @param object   任意对象
	 * @return java.lang.String
	 */
	public static String objectToJson(Object object) {
		StringBuilder json = new StringBuilder();
		if (object == null) {
			json.append("\"\"");
		} else if (object instanceof String || object instanceof Integer) {
			json.append("\"").append((String)object).append("\"");
		} else {
			json.append(beanToJson(object));
		}
		return json.toString();
	}

	/**
	 * 功能描述:传入任意一个 javabean 对象生成一个指定规格的字符串
	 * 
	 * @param bean
	 *            bean对象
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod().invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * 功能描述:通过传入一个列表对象,调用指定方法将列表中的数据生成一个JSON规格指定字符串
	 * 
	 * @param list
	 *            列表对象
	 * @return java.lang.String
	 */
	public static String listToJson(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static Map getMap4Json(String jsonString){
		 JSONObject jsonObject = JSONObject.fromObject( jsonString );
		 Iterator keyIter = jsonObject.keys();
		 String key;
		 Object value;
		 Map valueMap = new HashMap();
		 while( keyIter.hasNext())
		 {
		 key = (String)keyIter.next();
		 value = jsonObject.get(key);
		 valueMap.put(key, value);
		 }
		 return valueMap;
		 }
	/**
	 * jsonString 转 MAP
	 * @param resp
	 * @return
	 */
	public Map<String,Object> JsonStrToMap(String resp){
		JSONObject json = new JSONObject();
		 Map map = JsonUtil.getMap4Json(resp);
		 Object ss =  map.get("message");
		 String s1 = ss.toString();
		 map =JsonUtil.getMap4Json(s1);
		 Map<String,Object> row= (Map<String, Object>) map.get("rows");
		return row;
	}
	
}