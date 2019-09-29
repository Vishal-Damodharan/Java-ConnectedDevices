/**
 * 
 */
package neu.vishald.connecteddevices.labs.module02;

import java.util.logging.Logger;

import com.labbenchstudios.edu.connecteddevices.common.BaseDeviceApp;
import com.labbenchstudios.edu.connecteddevices.common.DeviceApplicationException;

/**
 *
 */
public class TempSimulatorApp extends BaseDeviceApp {
	// static

	private static final Logger _Logger = Logger.getLogger(TempSimulatorApp.class.getSimpleName());

	/**
	 * The main function calls the object instance of the TempSimulatorApp
	 */
	public static void main(String[] args) {
		TempSimulatorApp app = new TempSimulatorApp(TempSimulatorApp.class.getSimpleName(), args);
		app.startApp();

	}

	// private var's

	// constructors

	/**
	 * Default.
	 * 
	 */
	public TempSimulatorApp() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param appName
	 */
	public TempSimulatorApp(String appName) {
		super(appName);
	}

	/**
	 * Constructor.
	 * 
	 * @param appName
	 * @param args
	 */
	public TempSimulatorApp(String appName, String[] args) {
		super(appName, args);
	}

	// protected methods

	/*
	 * This function is to start the run function in the Emulator
	 */
	@Override
	protected void start() throws DeviceApplicationException {
		_Logger.info("Hello - module02 here!");
		TempSensorEmulator temp = new TempSensorEmulator();
		temp.run();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.labbenchstudios.edu.connecteddevices.common.BaseDeviceApp#stop()
	 */
	@Override
	protected void stop() throws DeviceApplicationException {
		_Logger.info("Stopping module02 app...");
	}

}
