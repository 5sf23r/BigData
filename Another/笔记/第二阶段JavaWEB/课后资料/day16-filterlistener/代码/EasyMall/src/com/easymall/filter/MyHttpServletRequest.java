package com.easymall.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper{
	
	public HttpServletRequest request = null;
	public String encode = "";
//								�˴�Ϊ�û������request����
	public MyHttpServletRequest(HttpServletRequest request,String encode) {
		super(request);
		//���û������request������ȡ��һ����Ա�������Ա�������������ʹ�á�
		this.request = request;
		this.encode = encode;
	}
	
	@Override
	public Map<String,String[]> getParameterMap() {
		try {
			//�������Ľ�����ݷ���һ���µ�map�������ء�
			//�Ӿ�mapȡ���������������
			Map<String,String[]> map = request.getParameterMap();
			//��map���洢������û�����������
			Map<String,String[]> rmap = new HashMap<String,String[]>();
			//������������
			for(Map.Entry<String, String[]> entry:map.entrySet()){
				//ȡ������ֵ�������е�ֵ��������Ĵ���
				String key = entry.getKey();
				String[] values = entry.getValue();
				//�µ�String���飬���ڴ洢������ֵ
				String[] rvalues = new String[values.length];
				//�����е�ֵ��������Ĵ���
				for(int i=0;i<values.length;i++){
					rvalues[i] = new String(values[i].getBytes("iso8859-1"),encode);
				}
				//�������Ľ�������µ�map��
				rmap.put(key, rvalues);
			}
			//������Ӻ��������ĵ�map����
			return rmap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public String[] getParameterValues(String name) {
		//���õ����ڱ������޸ĺõķ�����ǧ��Ҫ��request��������Ϊԭ�е�request�������ϵķ���
		Map<String,String[]> map = getParameterMap();
		return map.get(name);
	}
	@Override
	public String getParameter(String name) {
		//�����û�����Ĳ�������ȡ��Ӧ���ƵĲ���ֵ��
		//���Ϊһ�����飬ȡ�������е�һ��Ԫ�ؼ�ΪgetParameter�����ķ���ֵ
		String[] values = getParameterValues(name);
		//���Ƿ����еĲ������ܲ����ڣ�
		//����ִ�з�������varlues=null�Ľ����
		//Ϊ�˱���null[0]���������Ӧ�ö�values������������жϡ�
		return values==null?null:values[0];
		
		
	}
	
	
}
