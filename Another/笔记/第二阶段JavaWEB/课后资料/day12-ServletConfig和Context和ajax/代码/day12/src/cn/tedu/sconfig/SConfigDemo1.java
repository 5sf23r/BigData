package cn.tedu.sconfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ServletConfig   ���Ի�ȡservlet�еĳ�ʼ��������Ϣ
public class SConfigDemo1 extends HttpServlet {
	ServletConfig config = null;
	//1.��ȡServletConfig����
	//��ȡ��ʽ��ͨ��init����
	@Override
	public void init(ServletConfig config) throws ServletException {
		//���config������Ҫ��doGet����ʹ��
		//��Ӧ�ý�config������ȡ��һ����Ա����
		this.config = config;
//		super.init(config);
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ӵ�ǰservlet���ϻ�ȡָ�����Ƶĳ�ʼ��������Ϣ��
		String username = config.getInitParameter("username");
		System.out.println("username:"+username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
