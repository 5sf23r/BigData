package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����а����Ŀͻ��˲�����
 * 	��ȡ�ͻ��˲�����API
 * @author Administrator
 *
 */
public class RequestDemo1 extends HttpServlet {
//	getRequestURL���� -- ���ؿͻ��˷�����������URL
//	getRequestURI���� -- �����������е���Դ������
//	getQueryString���� -- �����������еĲ�������
//	getRemoteAddr���� -- ���ط�������Ŀͻ�����IP��ַ
//	getMethod -- �õ��ͻ�������ʽ
//	!!getContextPath -- ��õ�ǰwebӦ������Ŀ¼���� -- ��д·��ʱ��Ҫ��webӦ�õ�����·��������д��, Ӧ������ҪдwebӦ�õ����Ƶĵط�ͨ��getContextPath������̬��ȡ

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("url:"+url);
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		String qs = request.getQueryString();
		System.out.println("qs:"+qs);
		String ip = request.getRemoteAddr();//ipconfig
		System.out.println("ip:"+ip);
		String method = request.getMethod();
		System.out.println("method:"+method);
		String cp = request.getContextPath();
		System.out.println("cp:"+cp);    //request.getContextPath()+/servlet
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
