package controllers;
import javax.mail.*;
import javax.mail.internet.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entites.BooleanResponse;



import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import java.util.Properties;

@Path("Mail")
public class Mail {
	
	@GET
	@Path("/sendMail")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static BooleanResponse sendMail(){
		System.out.println("it workingggggggggggg");
		// Set up the SMTP server.
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", "smtp.myisp.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
    
		//Session session = Session.getDefaultInstance(props, null);
		Session session = Session.getDefaultInstance(props,
			    new Authenticator() {
			        protected PasswordAuthentication  getPasswordAuthentication() {
			        return new PasswordAuthentication(
			                    "a0548494053@gmail.com", "asas1212!");
			                }
			    });
		
		
		
		
		// Construct the message
		String to = "m0548415655@gmail.com";
		String from = "a0548494053@gmail.com";
		String subject = "Hello";
//		
//		SmtpAuthenticator authentication = new SmtpAuthenticator();
//		javax.mail.Message msg = new MimeMessage(Session
//		                    .getDefaultInstance(emailProperties, authenticator));
//		
//		
		
		
		Message msg = new MimeMessage(session);
		try {
		    msg.setFrom(new InternetAddress(from));
		    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    msg.setSubject(subject);
		    msg.setText("Hi,\n\nHow are you?");

		    // Send the message.
		    Transport.send(msg);
		    return new BooleanResponse(true);
		} catch (MessagingException e) {
		    e.printStackTrace();
		}
		return new BooleanResponse(false);
	}
	
}
