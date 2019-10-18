package neu.vishald.connecteddevices.labs.module01;

import java.io.BufferedOutputStream;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/*
 * Creating a runnable thread for CpuUtil
 */
public class SystemCpuUtilTask implements Runnable {

	/*
	 * Importing osBean for system memory usage values
	 */
	OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
	
	/*
	 * What % CPU load this current JVM is taking, from 0.0-1.0
	 */
	public Thread SystemCpuUtilTask(Runnable r) {
		return new Thread(r);
	}

	/*
	 * This run function is used to run the thread for the CPU usage
	 */
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nCPU performance");
		System.out.println(osBean.getProcessCpuLoad());
		// What % load the overall system is at, from 0.0-1.0
		System.out.println(osBean.getSystemCpuLoad());
	}
	
	public float getCPU() {
		return 101;
	}
}