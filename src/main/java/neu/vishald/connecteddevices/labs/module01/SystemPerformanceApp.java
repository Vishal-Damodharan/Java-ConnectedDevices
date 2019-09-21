package neu.vishald.connecteddevices.labs.module01;

import java.util.logging.Logger;

import com.labbenchstudios.edu.connecteddevices.common.BaseDeviceApp;
import com.labbenchstudios.edu.connecteddevices.common.DeviceApplicationException;

import neu.vishald.connecteddevices.labs.module01.SystemPerformanceAdaptor;


public class SystemPerformanceApp extends BaseDeviceApp {
	
	private static final Logger _Logger = Logger.getLogger(SystemPerformanceApp.class.getSimpleName());

	public static void main(String[] args) {
		// SystemPerformanceApp app = new
		// SystemPerformanceApp(SystemPerformanceApp.class.getSimpleName());
		SystemPerformanceApp app = new SystemPerformanceApp();
		app.startApp();
	}

	private SystemPerformanceAdaptor _sysPerfAdaptor;

	public SystemPerformanceApp() {
		super();
		this._sysPerfAdaptor = new SystemPerformanceAdaptor(10);
	}

	public SystemPerformanceApp(String appName) {
		super(appName);
	}

	@Override
	protected void start() throws DeviceApplicationException {
		// TODO Auto-generated method stub
		this._sysPerfAdaptor.startPolling();
	}

	@Override
	protected void stop() throws DeviceApplicationException {
		// TODO Auto-generated method stub
		this._sysPerfAdaptor.stopPolling();
	}
}