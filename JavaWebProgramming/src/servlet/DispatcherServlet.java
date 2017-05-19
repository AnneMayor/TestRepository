package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet 	{
	@Override
	// ó�� server���� deploy�Ǿ� ��ü ������ �� ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("DispatcherServlet init()");
		
		String name1 = config.getInitParameter("name1");
		String name2 = config.getInitParameter("name2");
		
		System.out.println(name1);
		System.out.println(name2);
	}
	
	@Override
	// Ŭ���̾�Ʈ�� ��û �� ������ ����
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()");
	}
}
