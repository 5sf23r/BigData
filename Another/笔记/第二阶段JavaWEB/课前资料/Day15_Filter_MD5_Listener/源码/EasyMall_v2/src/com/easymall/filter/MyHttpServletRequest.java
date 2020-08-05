package com.easymall.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 装饰设计模式，改造和获取请求参数相关的三个方法，增加乱码解决逻辑
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
	private String encode = null;
	private HttpServletRequest request = null;
	
	public MyHttpServletRequest(String encode,HttpServletRequest request) {
		super(request);
		this.encode = encode;
		this.request = request;
	}
	
	@Override
	public Map<String,String[]> getParameterMap() {
		try {
			//--获取请求参数Map，有乱码
			Map<String,String[]> map = request.getParameterMap();
			//--创建目标Map
			Map<String,String[]> rmap = new HashMap<String, String[]>();
			//--遍历原Map，解决乱码，存入目标map
			for(Map.Entry<String, String[]> entry : map.entrySet()){
				String key = entry.getKey();
				String vs [] = entry.getValue();
				String rvs [] = new String[vs.length];
				for(int i = 0;i<vs.length;i++){
					rvs[i] = new String(vs[i].getBytes("iso8859-1"),encode);
				}
				rmap.put(key, rvs);
			}
			//--返回目标map
			return rmap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> rmap = getParameterMap();
		return rmap.get(name);
	}
	
	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		return values == null ? null : values[0];
	}
}
