/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Metier;

import java.util.regex.Pattern;

/**
 *
 * @author AYMEN
 */
public class ControleUtility {
    
    
    
 public static boolean isEmailValid(String email) {
    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",0x02);
    return EMAIL_REGEX.matcher(email).matches();
}
 
 
 public static boolean isPasswordValid (String password){
    final Pattern Password_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*[A-Za-z0-9].{8,}$", 0x02);
    return Password_REGEX.matcher(password).matches();
}
    
}
