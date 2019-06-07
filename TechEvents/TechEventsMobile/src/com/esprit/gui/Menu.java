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
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.esprit.Entity.User;
import com.esprit.Metier.UserSession;

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
        String msg="Bienvenue";
        if(UserSession.verifUserSession()){
             User u=UserSession.getUserSession();
            msg=msg+" "+u.getNom()+" "+u.getPrenom();
        }       
        forme.getToolbar().addMaterialCommandToLeftSideMenu(msg, FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                forme.showBack();
            }
        });
        Style s = UIManager.getInstance().getComponentStyle("Label");

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
        
        forme.getToolbar().addCommandToLeftSideMenu("Gérer réclamation", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  ListReclamation lst = new ListReclamation();
                  lst.getF().show();
            }
        });
        
        if(!UserSession.verifUserSession()){
            forme.getToolbar().addCommandToLeftSideMenu("Inscription",FontImage.createMaterial(FontImage.MATERIAL_CREATE, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                      Inscription inscription = new Inscription();

                      inscription.show();
                }
            });

            forme.getToolbar().addCommandToLeftSideMenu("Authentification", FontImage.createMaterial(FontImage.MATERIAL_OPEN_IN_NEW, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                      Authentification authentification = new Authentification();
                      authentification.show();
                }
            });
        }
        else{
                forme.getToolbar().addCommandToLeftSideMenu("Déconnexion", FontImage.createMaterial(FontImage.MATERIAL_CLOSE, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                       UserSession.destroyUserSession();
                      AccueilEvent accueilEvent = new AccueilEvent();
                      accueilEvent.show();
                }
            });
            
        }
    }
    
}
