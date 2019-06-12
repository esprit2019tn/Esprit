/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.regex.Pattern;

/**
 *
 * @author AYMEN
 */
public class ControleUtility {
    
    
    
 public static boolean isEmailValid(String email) {
    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
    return EMAIL_REGEX.matcher(email).matches();
}
 
 
 public static boolean isPasswordValid (String email){
    final Pattern Password_REGEX = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", Pattern.CASE_INSENSITIVE);
    return Password_REGEX.matcher(email).matches();
}
    
}
