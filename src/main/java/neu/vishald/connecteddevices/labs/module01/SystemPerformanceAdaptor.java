package neu.vishald.connecteddevices.labs.module01;

import java.util.logging.Logger;

import com.labbenchstudios.edu.connecteddevices.common.DevicePollingManager;

public class SystemPerformanceAdaptor extends DevicePollingManager {

	DevicePollingManager _pollManager;
	long _pollCycle;

	public SystemPerformanceAdaptor(long pollCycle) {
		super();
		if (pollCycle >= 1L) {
			_pollCycle = pollCycle;
		}
		_pollManager = new DevicePollingManager(10);
	}

	public void startPolling() {
		// Logger.info("Creating and scheduling CPU Utilization poller...");
		System.out.println("Creating and scheduling CPU Utilization poller...");
		this._pollManager.schedulePollingTask(new Thread(new SystemCpuUtilTask()), _pollCycle);
		// Logger.info("Creating and scheduling Memory Utilization poller...");
		System.out.println("Creating and scheduling Memory Utilization poller...");
		this._pollManager.schedulePollingTask(new Thread(new SystemMemUtilTask()), _pollCycle);
	}

}
