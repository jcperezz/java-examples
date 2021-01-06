package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * A simple manager for Quartz Scheduler
 * 
 * @author Juan Carlos Perez
 */
public class JobManager {

	private Scheduler scheduler;

	/**
	 * Instantiates a new job manager.
	 * 
	 * @throws SchedulerException
	 */
	public JobManager() throws SchedulerException {
		super();

		SchedulerFactory schedFact = new StdSchedulerFactory();
		scheduler = schedFact.getScheduler();
	}

	/**
	 * Start the scheduler.
	 *
	 * @throws SchedulerException the scheduler exception
	 */
	public void start() throws SchedulerException {
		final JobKey jobKey = new JobKey("example-job", "jcperezz-quartz-group");
		final JobDetail job = JobBuilder.newJob(JobExample.class).withIdentity(jobKey).build();

		// Every second
		CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("* * * * * ?");
		// SimpleScheduleBuilder.repeatSecondlyForever();

		final Trigger trigger = TriggerBuilder.newTrigger().withIdentity("example-job-trigger", "jcperezz-quartz-group")
				.withSchedule(cronSchedule).build();

		scheduler.start();

		try {
			scheduler.scheduleJob(job, trigger);
		} catch (ObjectAlreadyExistsException e) {
			System.out.println("The jcperezz-quartz-group.example-job job already exists on other server instance");
		}

		System.out.println("Scheduler started on " + System.getProperty("weblogic.Name"));
	}

	/**
	 * Stop the scheduler
	 * 
	 * @throws SchedulerException
	 */
	public void shutdown() throws SchedulerException {
		if (!scheduler.isShutdown()) {
			scheduler.shutdown();
			System.out.println("Scheduler stoped on " + System.getProperty("weblogic.Name"));
		}
	}

}
