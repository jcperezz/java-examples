package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.SchedulerException;

import quartz.JobManager;

/**
 * The listener implementation for receiving webApp events. The class that is
 * interested in processing a webApp event implements
 * {@link ServletContextListener} interface, the class is registered web.xml.
 * When the webApp event occurs, that object's appropriate method is invoked.
 * 
 * @author Juan Carlos Perez
 *
 */
public class WebAppListener implements ServletContextListener {
	
	private JobManager manager;

	/**
	 * Context initialized.
	 *
	 * @param sce the {@link ServletContextEvent}
	 */
	public void contextInitialized(ServletContextEvent sce) {
		
		final String weblogicName = System.getProperty("weblogic.Name");
		System.out.println("Running weblogic11g-quartz-clustering on " + weblogicName);

		try {
			manager = new JobManager();
			manager.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Context destroyed.
	 *
	 * @param sce the {@link ServletContextEvent}
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		
		final String weblogicName = System.getProperty("weblogic.Name");
		System.out.println("Closing weblogic11g-quartz-clustering on " + weblogicName);
	}

}
