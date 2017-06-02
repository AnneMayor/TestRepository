package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
	@Override
	// server���� deploy�� �� ����
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized()");
		String key1 = event.getServletContext().getInitParameter("key1");
		System.out.println(key1);
	}
	
	@Override
	// server���� undeploy�� �� ����
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyer()");
	}
}