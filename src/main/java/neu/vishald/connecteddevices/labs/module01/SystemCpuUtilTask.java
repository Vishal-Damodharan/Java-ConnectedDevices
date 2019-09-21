package neu.vishald.connecteddevices.labs.module01;

import java.io.BufferedOutputStream;
import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class SystemCpuUtilTask implements Runnable { // Creating a runnable thread

	OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class); // Importing osBean
																										// for system
																										// CPU usage
																										// values

	// What % CPU load this current JVM is taking, from 0.0-1.0
	public Thread SystemCpuUtilTask(Runnable r) {
		return new Thread(r);

	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nCPU performance");
		System.out.println(osBean.getProcessCpuLoad());
		// What % load the overall system is at, from 0.0-1.0
		System.out.println(osBean.getSystemCpuLoad());

	}

}
