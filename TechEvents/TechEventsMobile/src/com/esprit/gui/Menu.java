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
import com.esprit.Entity.Actualite;
import com.esprit.Entity.RoleUser;
import com.esprit.Entity.User;
import com.esprit.Metier.UserSession;

/**
 *
 * @author AYMEN
 */
public class Menu {
 
    
    public static void getMenu(Form forme){
       // UserSession.destroyUserSession();
        forme.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AccueilEvent act = new AccueilEvent();
                act.show();
            }
        });
        String msg = "Bienvenue";
        if (UserSession.verifUserSession()) {
            User u = UserSession.getUserSession();
            msg = msg + " " + u.getNom() + " " + u.getPrenom();
        }
        forme.getToolbar().addMaterialCommandToLeftSideMenu(msg, FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    ListEvent tse = new ListEvent();
                    tse.getF().show();
            }
        });
        Style s = UIManager.getInstance().getComponentStyle("Label");
        
          forme.getToolbar().addMaterialCommandToLeftSideMenu("Liste évenements", FontImage.MATERIAL_LIST , new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ListEvent tse = new ListEvent();
                    tse.getF().show();
                }
            });
        
   
        forme.getToolbar().addMaterialCommandToLeftSideMenu("Actualite", FontImage.MATERIAL_NOTIFICATIONS , new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   // Actualite a=new Actualite();
                   ActualiteForm a = new ActualiteForm();
                    a.showList(forme);
                }
            });
       
        forme.getToolbar().addMaterialCommandToLeftSideMenu("Gérer réclamation", FontImage.MATERIAL_FLAG , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  ListReclamation lst = new ListReclamation();
                  lst.getF().show();
                  
            }
        });
        
        forme.getToolbar().addMaterialCommandToLeftSideMenu("Mes réservations", FontImage.MATERIAL_FAVORITE , new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent evt) {
                    ListReservation tse = new ListReservation();
                    tse.getF().show();
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
            forme.getToolbar().addCommandToLeftSideMenu("Utilisateur", FontImage.createMaterial(FontImage.MATERIAL_PERSON, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                      UserInfo userInfo = new UserInfo();
                      userInfo.show();
                }
            });     
            forme.getToolbar().addCommandToLeftSideMenu("Déconnexion", FontImage.createMaterial(FontImage.MATERIAL_CLOSE, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    UserSession.destroyUserSession();
                    AccueilEvent accueilEvent = new AccueilEvent();
                    accueilEvent.show();
                }
            });

        }
        
        if(UserSession.verifUserSession() && UserSession.getUserSession().getRole().equals(RoleUser.Admin) ){ 
            
                    forme.getToolbar().addMaterialCommandToLeftSideMenu("Gérer événement", FontImage.MATERIAL_WORK, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (UserSession.verifUserSession()) {
                    User user = UserSession.getUserSession();
                    if (user.getRole().equals(user.getRole().Admin)) {
                        AddEvt adv = new AddEvt();
                        adv.getF().show();
                    }
                    else {
                        ListEvent lse = new ListEvent();
                        lse.getF().show();
                    }
                }

            }
        });
                forme.getToolbar().addCommandToLeftSideMenu("valider utilisateur", FontImage.createMaterial(FontImage.MATERIAL_CLOSE, s).toImage(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                       UserSession.destroyUserSession();
                      ValidationUser validationUser = new ValidationUser();
                      validationUser.show();
                }
            });
        }
    }


    }