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
	 * This function is to initialize the props file in ConfigUtil and make it get the 
    	value of host, port, email address and password.
	 */
	public static void sendMail(String recipient, String data) throws Exception {
		System.out.println("Preparing to send email .. ");
		Properties properties = new Properties();
//		properties.put("mail.smtp.auth"	,"true");
		properties.put(ConfigConst.SMTP_PROP_AUTH_KEY, "true");

//		properties.put("mail.smtp.starttls.enable","true");
		properties.put(ConfigConst.SMTP_PROP_ENABLE_TLS_KEY, "true");

//		properties.put("mail.smtp.host"	,"smtp.gmail.com");
		properties.put(ConfigConst.SMTP_PROP_HOST_KEY, "smtp.gmail.com");
//		properties.put("mail.smtp.port"	,"587");
		properties.put(ConfigConst.SMTP_PROP_PORT_KEY, "587");
//		System.out.println(ConfigConst.PORT_KEY);
//		System.out.println(ConfigUtil.getInstance().hasProperty(ConfigConst.SMTP_CLOUD_SECTION, ConfigConst.PORT_KEY));
//		System.out.println(ConfigConst.DEFAULT_CONFIG_FILE_NAME);
		final String myAccountEmail = "vishalcd.iot@gmail.com";
		final String password = "xqxbufjgccutoaam";

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
