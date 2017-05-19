package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
	@Override
	// server에서 deploy될 때 시행
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized()");
		String key1 = event.getServletContext().getInitParameter("key1");
		System.out.println(key1);
	}
	
	@Override
	// server에서 undeploy될 때 시행
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyer()");
	}
}
