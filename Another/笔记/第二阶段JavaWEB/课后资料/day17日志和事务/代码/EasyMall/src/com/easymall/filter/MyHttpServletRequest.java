package com.easymall.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper{
	
	public HttpServletRequest request = null;
	public String encode = "";
//								此处为用户传入的request对象
	public MyHttpServletRequest(HttpServletRequest request,String encode) {
		super(request);
		//将用户传入的request对象提取成一个成员变量，以便在其他方法中使用。
		this.request = request;
		this.encode = encode;
	}
	
	@Override
	public Map<String,String[]> getParameterMap() {
		try {
			//将处理后的结果数据放入一个新的map，并返回。
			//从旧map取出包含乱码的数据
			Map<String,String[]> map = request.getParameterMap();
			//新map，存储处理后的没有乱码的数据
			Map<String,String[]> rmap = new HashMap<String,String[]>();
			//处理乱码数据
			for(Map.Entry<String, String[]> entry:map.entrySet()){
				//取出键和值，对其中的值进行乱码的处理
				String key = entry.getKey();
				String[] values = entry.getValue();
				//新的String数组，用于存储处理后的值
				String[] rvalues = new String[values.length];
				//对其中的值进行乱码的处理
				for(int i=0;i<values.length;i++){
					rvalues[i] = new String(values[i].getBytes("iso8859-1"),encode);
				}
				//将处理后的结果放入新的map中
				rmap.put(key, rvalues);
			}
			//返回添加好正常中文的map对象
			return rmap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public String[] getParameterValues(String name) {
		//调用的是在本类中修改好的方法，千万不要加request，否则会变为原有的request对象身上的方法
		Map<String,String[]> map = getParameterMap();
		return map.get(name);
	}
	@Override
	public String getParameter(String name) {
		//根据用户传入的参数名获取对应名称的参数值，
		//结果为一个数组，取出数组中第一个元素即为getParameter方法的返回值
		String[] values = getParameterValues(name);
		//考虑方法中的参数可能不存在，
		//导致执行方法出现varlues=null的结果。
		//为了避免null[0]这种情况，应该对values结果做出如下判断。
		return values==null?null:values[0];
		
		
	}
	
	
}
