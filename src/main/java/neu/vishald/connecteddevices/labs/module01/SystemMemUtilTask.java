package neu.vishald.connecteddevices.labs.module01;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/*
 * implementing runnable thread
 */
public class SystemMemUtilTask implements Runnable {
	
	/*
	 * Importing osBean for system memory usage values
	 */
	OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
	
	public SystemMemUtilTask() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * This run function is used to run the thread for the memory usage
	 */
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Memory util");
		System.out.println(osBean.getTotalPhysicalMemorySize());
	}
}