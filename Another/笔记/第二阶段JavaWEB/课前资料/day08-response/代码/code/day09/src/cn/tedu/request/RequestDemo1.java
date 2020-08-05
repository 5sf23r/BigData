package cn.tedu.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request����: ��ȡ�ͻ��˻�����Ϣ request����: ��ȡ����ͷ��Ϣ
 */
public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* request����: ��ȡ�ͻ��˻�����Ϣ */
		// getRequestURL���� -- ���ؿͻ��˷�����������URL
		String url = request.getRequestURL().toString();
		System.out.println("url: " + url);

		// getRequestURI���� -- �����������е���Դ������
		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);

		// getQueryString���� -- �����������еĲ�������
		String qs = request.getQueryString();
		System.out.println("qs: " + qs);

		// getRemoteAddr���� -- ���ط�������Ŀͻ�����IP��ַ
		String ip = request.getRemoteAddr();
		System.out.println("ip: " + ip);

		// getMethod���� -- ���ؿͻ���������ʽ
		String method = request.getMethod();
		System.out.println("method: " + method);

		// !!!getContextPath���� -- ��õ�ǰwebӦ�õ�����Ŀ¼����

		String contextpath = request.getContextPath();
		System.out.println("cp: " + contextpath);

		// response.sendRedirect(request.getContextPath()+"/index.jsp");

		// ================================================

		/* request����: ��ȡ����ͷ��Ϣ */
		// getHeader(name)���� --- String
		
		String host = request.getHeader("host");
		System.out.println("host: "+host);
		
		// getHeaders(String name)���� --- Enumeration<String>
		Enumeration values = request.getHeaders("host");
		while (values.hasMoreElements()) {
			String value = (String) values.nextElement();
			System.out.println("value: "+value);
		}
		
		// getHeaderNames���� --- Enumeration<String>
		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = (String) headers.nextElement();
			String value = request.getHeader(header);
			System.out.println(header+" : "+value);
		}
		
		// getIntHeader(name)���� --- int
		// getDateHeader(name)���� --- long(���ڶ�Ӧ����)
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
