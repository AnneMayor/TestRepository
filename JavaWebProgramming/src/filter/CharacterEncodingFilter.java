package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	
	private String characterSet;
	
	@Override
	// ó�� Filter��� ��ü�� ������ �� ����
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter init()");
		characterSet = filterConfig.getInitParameter("encoding");
		
	}
	
	@Override
	// Ŭ���̾�Ʈ�� ��û�� ������ ����
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// ��ó��(������ �����ϱ� ���� ó��: ��û ó����)
		System.out.println("CharacterEncodingFilter doFilter() - ��ó��");
		request.setCharacterEncoding(characterSet);
		// -------------------------------------------------------------
		System.out.println("CharacterEncodingFilter doFilter()");
		filterChain.doFilter(request, response);
		// -------------------------------------------------------------
		// ��ó��(������ ������ �Ŀ� ó��: ��û ó���� = ������ ������ ��)
		System.out.println("CharacterEncodingFilter doFilter() - ��ó��");
	}

	@Override
	public void destroy() {
		System.out.println("CharaterEncodingFilter destroy()");
	}
	
}