package neu.vishald.connecteddevices.labs.module06;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.labbenchstudios.edu.connecteddevices.common.ConfigConst;
import com.labbenchstudios.edu.connecteddevices.common.SensorData;
import com.labbenchstudios.edu.connecteddevices.common.DataUtil;

/*
 * This class is used for the subscriber client
 */
public class MqttSubClientTestApp {

	private static final Logger logger = Logger.getLogger(MqttSubClientTestApp.class.getName());
	private static MqttSubClientTestApp app;
	private MqttClientConnector mqttClient;

	/*
	 * Constructor
	 */
	public MqttSubClientTestApp() {
		super();
	}

	/*
	 * This method is used to initialize the subscribe method
	 */
	public void start(String topicName) {
		mqttClient = new MqttClientConnector();
		mqttClient.connect();
		mqttClient.subscribeToTopic(topicName);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mqttClient.disconnect();
	}

	/*
	 * The main method is implemented to set the topic and also to convert json to
	 * sensordata and vice versa
	 */
	public static void main(String[] args) {

		app = new MqttSubClientTestApp();
		String topic = "Temperature Sensor";

		try {
			app.start(topic);
			String message = MqttClientConnector.getMessag();
			System.out.println("Received Json Data\n");
			System.out.println("Received Json Message is :" + "\n" + message + "\n");

			DataUtil data = new DataUtil();
			SensorData sensor = data.JsonToSensorData(message, null);
			System.out.println("Printing the Sensor Data:\n");
			System.out.println("After the Json data to Sensor data Conversion:\n" + sensor);

			String json = data.SensorDataToJson(sensor);
			System.out.println("Printing the Json Data:\n");
			System.out.println("After Sensor data to Json data Conversion:\n" + json);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}