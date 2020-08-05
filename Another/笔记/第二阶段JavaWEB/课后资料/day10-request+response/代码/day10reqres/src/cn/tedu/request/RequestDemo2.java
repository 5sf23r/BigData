package cn.tedu.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ȡ�����е�ͷ��Ϣ
 * @author Administrator
 *
 */
public class RequestDemo2 extends HttpServlet {
//	getHeader(name)���� --- String 
//	getHeaders(String name)���� --- Enumeration<String>
//	getHeaderNames���� --- Enumeration<String>
//	getIntHeader(name)����  --- int
//	getDateHeader(name)���� --- long(���ڶ�Ӧ����)

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String host = request.getHeader("Host");
		System.out.println("host:"+host);
		
		//getHeaders�������Ի�ȡ���ͬ��������ͷ��Ӧ�����ݣ�
		//��Щ���ݻ����һ����������,����ͨ������ѭ����ȡ��
		Enumeration<String> headers = request.getHeaders("Host");
		while (headers.hasMoreElements()) {
			String string = (String) headers.nextElement();
			System.out.println("head:"+string);
		}
		
		//��ȡȫ��������ͷ
		//��ݼ���ȡ����ֵ��Alt+Shift+L; ע�⣺���������
		Enumeration<String> headernames = request.getHeaderNames();
		while (headernames.hasMoreElements()) {
			//����ȫ������ͷ�����ƣ�
			String string = (String) headernames.nextElement();
			//��������ͷ��ȡȫ��ͷ��Ӧ��ֵ��
			String value = request.getHeader(string);
			System.out.println("header:"+string+">>>>value:"+value);
		}
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
