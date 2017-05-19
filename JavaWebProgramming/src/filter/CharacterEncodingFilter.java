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
	// 처음 Filter라는 객체가 생성될 때 시행
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter init()");
		characterSet = filterConfig.getInitParameter("encoding");
		
	}
	
	@Override
	// 클라이언트가 요청할 때마다 시행
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 전처리(서블릿이 실행하기 전에 처리: 요청 처리전)
		System.out.println("CharacterEncodingFilter doFilter() - 전처리");
		request.setCharacterEncoding(characterSet);
		// -------------------------------------------------------------
		System.out.println("CharacterEncodingFilter doFilter()");
		filterChain.doFilter(request, response);
		// -------------------------------------------------------------
		// 후처리(서블릿이 실행한 후에 처리: 요청 처리후 = 응답을 보내기 전)
		System.out.println("CharacterEncodingFilter doFilter() - 후처리");
	}

	@Override
	public void destroy() {
		System.out.println("CharaterEncodingFilter destroy()");
	}
	
}