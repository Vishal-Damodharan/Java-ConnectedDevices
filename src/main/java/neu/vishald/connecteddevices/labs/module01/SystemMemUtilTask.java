package neu.vishald.connecteddevices.labs.module01;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class SystemMemUtilTask implements Runnable { // implementing runnable thread
	OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class); // Importing osBean
																										// for system
																										// memory usage
																										// values
	// What % CPU load this current JVM is taking, from 0.0-1.0

	public SystemMemUtilTask() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Memory util");
		System.out.println(osBean.getTotalPhysicalMemorySize());
	}

}
