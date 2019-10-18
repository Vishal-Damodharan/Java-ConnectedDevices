package neu.vishald.connecteddevices.labs.module05;

import java.util.logging.Logger;

import com.labbenchstudios.edu.connecteddevices.common.BaseDeviceApp;
import com.labbenchstudios.edu.connecteddevices.common.DeviceApplicationException;

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

	public TempSimulatorApp() {
		super();
	}

	public TempSimulatorApp(String appName) {
		super(appName);
	}

	public TempSimulatorApp(String appName, String[] args) {
		super(appName, args);
	}

	/*
	 * This function is to start the run function in the Emulator
	 */
	@Override
	protected void start() throws DeviceApplicationException {
		_Logger.info("Hello - module02 here!");
		System.out.println("Reading json data from python app.... ");
		System.out.println("\nPrinting the json data from python app as sensor data as Sample 0:\n");
		TempEmulatorAdaptor.demo();
	}

	/*
	 * This function is to stop the run function in the Emulator
	 */
	@Override
	protected void stop() throws DeviceApplicationException {
		_Logger.info("Stopping module02 app...");
	}

}