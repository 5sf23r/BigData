package cn.tedu.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ת����ϸ�ڣ�
 * 	��RequestDemo7һ��
 * @author Administrator
 *
 */
public class RequestDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ת��֮ǰ���response�������������ݣ�
		//��������ת����ʱ��Ὣresponse��������ա�
//		response.getWriter().write("aaa");
		//��ˢ������
		//���������ת��֮ǰ��ˢresponse������������һ����Ӧ������
		//һ������һ����Ӧ����������ת���е���Ӧ���޷�ʵ�֡�
		//��Ϊ������ת����ģ����ֻ�ܳ���һ����Ӧ��
		//��ˢ�������Ѿ����һ����Ӧ��������ô����ת���е���Ӧ���޷������������������ձ���
//		response.flushBuffer();
		//����ת��
		request.getRequestDispatcher("/servlet/RequestDemo7").forward(request, response);
		//���������ת��֮���ˢ����������ôΪʱ��������ת���Ѿ�������Ӱ�춯����
		//�����ٴ�ִ����Ӧ�����ˡ�
//		response.getWriter().write("aaa");
//		response.flushBuffer();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
