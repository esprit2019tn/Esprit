
package com.esprit.Metier;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author AYMEN
 */
public class EmailSend {

    public static void sendConfirmation(String email,String code){
        Message m = new Message("C'est le numéro de confirmation de votre compte. Veuillez insérer ce numéro pour activer votre compte. <"+code+">");
     
            //m.getAttachments().put(textAttachmentUri, "text/plain");
            //m.getAttachments().put(imageAttachmentUri, "image/png");
            Display.getInstance().sendMessage(new String[] {email}, "Confirmation du compte.", m);       
    }
    
    
        public static void sendRecuperMail(String email,String code){

    }
}
