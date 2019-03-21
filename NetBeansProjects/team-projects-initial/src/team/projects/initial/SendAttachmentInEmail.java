package team.projects.initial;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author Ian and Carl
 */
public class SendAttachmentInEmail {
   public SendAttachmentInEmail() {
     
      final String username = "teamproject5cc518@gmail.com";
      final String password = "teamprojectsinitial";

      Properties props = new java.util.Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });
      
       Message msg = new MimeMessage(session);
    try {
        msg.setFrom(new InternetAddress("teamproject5cc518@gmail.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress("teamproject5cc518@gmail.com"));
        msg.setSubject("Motion Alert");

        Multipart multipart = new MimeMultipart();

        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText("Motion has taken place");

        MimeBodyPart attachmentBodyPart= new MimeBodyPart();
        DataSource source = new FileDataSource("/home/pi/Pictures/A Cool Picture.jpg");
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName("A Cool Picture.jpg"); // ex : "test.pdf"

        multipart.addBodyPart(textBodyPart);  // add the text part
        multipart.addBodyPart(attachmentBodyPart); // add the attachement part

        msg.setContent(multipart);
        
        Transport.send(msg);
        System.out.println("Sent message successfully....");
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }    
  }
}
/* https://jar-download.com/artifacts/com.sun.mail/javax.mail/1.6.2 */