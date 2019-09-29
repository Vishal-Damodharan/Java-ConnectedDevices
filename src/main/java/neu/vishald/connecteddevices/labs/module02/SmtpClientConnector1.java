package neu.vishald.connecteddevices.labs.module02;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.labbenchstudios.edu.connecteddevices.common.ConfigConst;
import com.labbenchstudios.edu.connecteddevices.common.ConfigUtil;

public class SmtpClientConnector1 {

	/*
	 * This function is to initialize the props file in ConfigUtil and make it get
	 * the value of host, port, email address and password.
	 */
	public static void sendMail(String recipient, String data) throws Exception {
		System.out.println("Preparing to send email .. ");
		ConfigUtil.getInstance().loadConfig();
		Properties properties = new Properties();
		properties.put(ConfigConst.SMTP_PROP_AUTH_KEY, "true");
		properties.put(ConfigConst.SMTP_PROP_ENABLE_TLS_KEY, "true");
		properties.put(ConfigConst.SMTP_PROP_HOST_KEY,
				ConfigUtil.getInstance().getProperty(ConfigConst.SMTP_CLOUD_SECTION, ConfigConst.HOST_KEY));
		properties.put(ConfigConst.SMTP_PROP_PORT_KEY,
				ConfigUtil.getInstance().getProperty(ConfigConst.SMTP_CLOUD_SECTION, ConfigConst.PORT_KEY));

		final String myAccountEmail = ConfigUtil.getInstance().getProperty(ConfigConst.SMTP_CLOUD_SECTION,
				ConfigConst.FROM_ADDRESS_KEY);
		final String password = ConfigUtil.getInstance().getProperty(ConfigConst.SMTP_CLOUD_SECTION,
				ConfigConst.USER_AUTH_TOKEN_KEY);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recipient, data);
		Transport.send(message);
		System.out.println("Message sent successfully");

	}

	/*
	 * The prepareMessage function is used to send the sensor data into the email using SMTP
	 */
	private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String data) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Temperature Notification: ");
			message.setText(data);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
