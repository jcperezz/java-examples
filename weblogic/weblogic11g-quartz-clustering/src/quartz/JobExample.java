package quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * The Job Quartz implementation to beperformed.
 * @author Juan Carlos Perez
 */
public class JobExample implements Job {

	/**
	 * Execute.
	 *
	 * @param context the context
	 * @throws JobExecutionException the job execution exception
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		final String weblogicName = System.getProperty("weblogic.Name");
		System.out.println("This is a Job started on " + weblogicName + " That is Scheduled At " + new Date());

		try {
			Date date = new Date();
			CronExpression cronExpression = new CronExpression("0/20 * * * * ?"); // Every 20 seconds

			if (cronExpression.isSatisfiedBy(date)) {
				System.out.println("Every 20 seconds");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
