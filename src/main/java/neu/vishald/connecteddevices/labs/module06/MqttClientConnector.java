/*
 * Created on Oct 19, 2019
 * @author: VISHAL
 */

package neu.vishald.connecteddevices.labs.module06;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.labbenchstudios.edu.connecteddevices.common.SensorData;

import com.labbenchstudios.edu.connecteddevices.common.ConfigConst;

/*
 * This class is implemented to connect the publisher and subscriber client 
 * with the MQTT broker.
 */
public class MqttClientConnector implements MqttCallback {

	private static final Logger logger = Logger.getLogger(MqttClientConnector.class.getName());
	private String protocol = ConfigConst.DEFAULT_MQTT_PROTOCOL;
	private String host = ConfigConst.DEFAULT_MQTT_SERVER;
	private int port = ConfigConst.DEFAULT_MQTT_PORT;

	private String clientID;
	private String brokerAddr;
	private MqttClient mqttClient;
	private SensorData sensorData;
	private static String messag;

	/*
	 * This Constructor is used to set the host and broker address and also obtain
	 * the sensor data instance
	 */
	public MqttClientConnector() {
		if (host != null && host.trim().length() > 0) {
			this.sensorData = new SensorData(30.0, 0.0, "name", "Temperature");
			this.clientID = mqttClient.generateClientId();
			System.out.println("Using client id for broker connection: " + clientID);
			this.brokerAddr = protocol + "://" + host + ":" + port;
			System.out.println("Using URL for broker connection: " + brokerAddr);
		}
	}

	/*
	 * This function is used to get the mqttclient instance and connect with MQTT
	 * broker
	 */
	public void connect() {
		if (mqttClient == null) {
			MemoryPersistence persistence = new MemoryPersistence();
			try {
				mqttClient = new MqttClient(brokerAddr, clientID, persistence);
				MqttConnectOptions connOpts = new MqttConnectOptions();
				connOpts.setCleanSession(true);
				System.out.println("Connecting to broker: " + brokerAddr);
				mqttClient.setCallback(this);
				mqttClient.connect(connOpts);
				System.out.println("connected to broker: " + brokerAddr);
			} catch (MqttException ex) {
				logger.log(Level.SEVERE, "Failed to connect to broker" + brokerAddr, ex);
			}

		}
	}

	/*
	 * This disconnect function is implemented to disconnect the connection with the
	 * broker after all the packets are transfered.
	 */
	public void disconnect() {
		try {
			mqttClient.disconnect();
			System.out.println("Disconnect from broker: " + brokerAddr);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Failed to disconnect from broker: " + brokerAddr, ex);
		}
	}

	/*
	 * This function is used to publish the message from the publisher and
	 * initializing payload and QOS
	 */
	public boolean publishMessage(String topic, int qosLevel, byte[] payload) {
		boolean messageSent = false;
		try {
			System.out.println("Publishing message to topic: " + topic + "payload : " + Arrays.toString(payload));
			MqttMessage msg = new MqttMessage(payload);
			msg.setQos(qosLevel);
			mqttClient.publish(topic, msg);
			System.out.println("Message Published " + msg.getId());
			messageSent = true;
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Failed to publish Mqtt message " + ex.getMessage());
		}
		return messageSent;
	}

	/*
	 * This function uses try catch to subscribe to a topic
	 */
	public boolean subscribeToTopic(String topic) {
		boolean success = false;
		try {
			mqttClient.subscribe(topic);
			success = true;
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return success;
	}

	/*
	 * This function uses try catch to unsubscribe to a topic
	 */
	public boolean unsubscribeToTopic(String topic) {
		boolean success = false;
		try {
			mqttClient.unsubscribe(topic);
			success = true;
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return success;
	}

	/*
	 * This function is invoked when the connection is broken
	 */
	public void connectionLost(Throwable cause) {

		logger.log(Level.WARNING, "Connection to broker lost. Will retry soon.", cause);
	}

	/*
	 * This function is invoked if the message is arrived
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		MqttClientConnector.setMessag(message);
		System.out.println("Message arrived: " + topic + ", " + message.getId() + "\n");
		System.out.print("Message arrived: " + topic + ", " + message.getId() + "\n" + message + "\n");
	}

	/*
	 * This function is invoked when the message is delivered and the whole process
	 * is complete
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("Delivery Complete: " + token.getMessageId() + "-" + token.getResponse());
	}

	/*
	 * getting the message
	 */
	public static String getMessag() {
		return messag;
	}

	/*
	 * Setting the message
	 */
	public static void setMessag(MqttMessage message) {
		MqttClientConnector.messag = message.toString();
	}
}