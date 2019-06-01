/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author AYMEN
 */
public class Menu {
    
    public static void getMenu(Form forme){
               forme.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
        forme.showBack();
            }
        });
        
        forme.getToolbar().addMaterialCommandToLeftSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                forme.showBack();
            }
        });
        forme.getToolbar().addCommandToLeftSideMenu("Inscription", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  Inscription inscription = new Inscription();
                 
                  inscription.show();
            }
        });

        forme.getToolbar().addCommandToLeftSideMenu("Authentification", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  Authentification authentification = new Authentification();
                  authentification.show();
            }
        });
        
        forme.getToolbar().addCommandToLeftSideMenu("Gérer événement", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  AddEvt adv = new AddEvt();
                  adv.getF().show();
            }
        });
    }
    
}
