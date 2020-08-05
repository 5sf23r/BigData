package cn.tedu.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ȡ�������
 * @author Administrator
 *
 */
public class RequestDemo3 extends HttpServlet {
//	getParameter(String name) --- String ͨ��name���ֵ
//	getParameterValues(String name)  --- String[ ] ͨ��name��ö�ֵ checkbox
//	getParameterMap()  --- Map<String,String[ ]> key :name value: ��ֵ  ����ѯ�Ĳ���������һ��Map��
//	getParameterNames()  --- Enumeration<String> �������name

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//utf-8�������ģ�������Ҫ�����������ַ����޸�Ϊutf-8
		//֪ͨ������ʹ��utf-8�ַ�����������
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		
//		byte[] bytes = username.getBytes("iso8859-1");
//		username = new String(bytes,"utf-8");
		System.out.println("username:"+username);
		
//		String like = request.getParameter("like");
//		System.out.println("like:"+like);
		//���ͬ��������ȡ��Ҫʹ��getParameterValues����ȡ
		String[] like = request.getParameterValues("like");
		System.out.println("like:"+Arrays.toString(like));
		
		//��ȡȫ�������������
		Enumeration<String> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			//����ȫ���Ĳ�����
			String name = (String) pNames.nextElement();
			//���ݲ�������ȡ����ֵ    ���ڻ�ȡ�Ĳ���ֵ�п��ܻ��ж������������getParameterValues��ȡ���в���ֵ�������в���ֵ�����һ�����鵱�С�
			String[] value = request.getParameterValues(name);
			System.out.println("name:"+name+">>value:"+Arrays.toString(value));
		}
		
		//���û���ȫ���������Լ�����ֵ����һ��map�С�
		@SuppressWarnings({ "unused", "unchecked" })
		Map<String,String[]> map = request.getParameterMap();
		for(Entry<String,String[]> entry:map.entrySet()){
			String key = entry.getKey();
			String [] value = entry.getValue();
			System.out.println(key+":"+Arrays.toString(value));
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
