
package com.esprit.Metier;

import com.codename1.ui.Dialog;
import com.esprit.Entity.Event;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author AYMEN
 */
public class EmailSend {
        
    public static void sendConfirmation(String email,String code){
        try{
            String host ="smtp.gmail.com" ;
            String user = "TestEsprit7@gmail.com";
            String pass = "esprit123";
            String to = email;
            String from = "TestEsprit7@gmail.com";
            String subject = "C'est le numéro de confirmation de votre compte. Veuillez insérer ce numéro pour activer votre compte.";
            String messageText = "Numéro : "+code;
            boolean sessionDebug = false;

            Properties props = new Properties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

           // java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
 
    
    public static void sendRecuperMail(String email,String code){
        try{
            String host ="smtp.gmail.com" ;
            String user = "TestEsprit7@gmail.com";
            String pass = "esprit123";
            String to = email;
            String from = "TestEsprit7@gmail.com";
            String subject = "C'est votre mot de passe .";
            String messageText = "Mot de passe : "+code;
            boolean sessionDebug = false;

            Properties props = new Properties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
     public static void sendRepReclamation(String email,Event event){
        try{
            String host ="smtp.gmail.com" ;
            String user = "TestEsprit7@gmail.com";
            String pass = "esprit123";
            String to = email;
            String from = "TestEsprit7@gmail.com";
            String subject = "Réclamation";
            String messageText = "Votre réclamation sur l'évenement " + event.getTitre()+ " a été traité " ;
            boolean sessionDebug = false;

            Properties props = new Properties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
}
}
