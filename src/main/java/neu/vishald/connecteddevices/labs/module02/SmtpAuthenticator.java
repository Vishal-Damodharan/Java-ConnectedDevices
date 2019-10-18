/**
 * 
 */
package neu.vishald.connecteddevices.labs.module02;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author VISHAL
 *
 */
public class SmtpAuthenticator extends Authenticator {
	private String _emailAddr = ""; // get this from config file
	private String _emailAuth = ""; // get this from config file
	
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(_emailAddr, _emailAuth);
	}
}
