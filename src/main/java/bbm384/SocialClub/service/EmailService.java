package bbm384.SocialClub.service;

import bbm384.SocialClub.entity.Users;
import bbm384.SocialClub.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
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

@Service
public class EmailService {



    public void sendEmail(String email, String firstName, String lastName, String password) {

        try {

            final String from = "odevdeneme10@gmail.com";
            final String emailPassword = "deneme123";

            String toAddress = email;

            // JavaMail session object
            Session session;

            // The JavaMail message object
            Message mesg;

            //SMTP server properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", 587);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // authenticate sender username and password
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, emailPassword);
                }
            };

            // initialize session object
            session = Session.getInstance(properties, auth);
            session.setDebug(false);

            // initialize message object
            mesg = new MimeMessage(session);

            // from Address
            mesg.setFrom(new InternetAddress(from));

            // Email Addresses
            InternetAddress toAdd = new InternetAddress(toAddress);


            mesg.addRecipient(Message.RecipientType.TO, toAdd);

            // email Subject
            mesg.setSubject("The Social Distance - Password Recovery");

            // message body.
            Multipart mp = new MimeMultipart("related");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello "+firstName+" "+lastName+",\n\n"+"Here is your recovery password: "+ password +"\nPlease do not forget to change your password after you login.\n\n"+"Ignore this message if you are not the owner of this account");

            // Attach text and image to message body
            mp.addBodyPart(textPart);

            // Setting message content
            mesg.setContent(mp);

            // Send mail
            Transport.send(mesg);

        } catch (MessagingException e) {
            System.err.println(e);
            e.printStackTrace(System.err);
        }
    }


}