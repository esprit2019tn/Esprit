/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entity.User;
import com.esprit.Metier.UserSession;
import com.esprit.Service.ServiceUser;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class UserInfo extends com.codename1.ui.Form {
    User user ;
    public UserInfo() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public UserInfo(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        Menu.getMenu(this);
        if(UserSession.verifUserSession()){
            this.user=UserSession.getUserSession();
            gui_nom.setText(user.getNom());
            gui_prenom.setText(user.getPrenom());
            gui_deteNaiss.setDate(user.getDateNaiss());
            if(user.getSexe().equals("Homme"))
                gui_homme.setSelected(true);
            else if(user.getSexe().equals("Femme"))
                gui_homme.setSelected(true);
            gui_email.setText(user.getEmail());
            gui_adresse.setText(user.getAdresse());           
        }
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextField gui_ancienMotDePasse = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_nouveauMotDePasse = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_nom = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_prenom = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_deteNaiss = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.RadioButton gui_homme = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_femme = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextField gui_email = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_adresse = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_modifier = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_msgErreur = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_modifier.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_modifier) {
                onmodifierActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("UserInfo");
        setName("UserInfo");
        gui_Box_Layout_Y.setPreferredSizeStr("57.142857mm 76.190475mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_ancienMotDePasse.setHint("Ancien mot de passe");
                gui_ancienMotDePasse.setInlineStylesTheme(resourceObjectInstance);
        gui_ancienMotDePasse.setName("ancienMotDePasse");
        gui_ancienMotDePasse.setConstraint(com.codename1.ui.TextArea.PASSWORD);
        gui_nouveauMotDePasse.setHint("Nouveau mot de passe");
                gui_nouveauMotDePasse.setInlineStylesTheme(resourceObjectInstance);
        gui_nouveauMotDePasse.setName("nouveauMotDePasse");
        gui_nouveauMotDePasse.setConstraint(com.codename1.ui.TextArea.PASSWORD);
        gui_nom.setHint("Nom");
                gui_nom.setInlineStylesTheme(resourceObjectInstance);
        gui_nom.setName("nom");
        gui_prenom.setHint("Prenom");
                gui_prenom.setInlineStylesTheme(resourceObjectInstance);
        gui_prenom.setName("prenom");
        gui_deteNaiss.setText("...");
                gui_deteNaiss.setInlineStylesTheme(resourceObjectInstance);
        gui_deteNaiss.setName("deteNaiss");
        gui_deteNaiss.setType(1);
        gui_Box_Layout_X.setScrollableX(false);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setInlineAllStyles("alignment:center;");
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_email.setHint("Email");
                gui_email.setInlineStylesTheme(resourceObjectInstance);
        gui_email.setName("email");
        gui_email.setConstraint(com.codename1.ui.TextArea.EMAILADDR);
        gui_adresse.setHint("Adresse");
                gui_adresse.setInlineStylesTheme(resourceObjectInstance);
        gui_adresse.setName("adresse");
        gui_modifier.setText("modifier");
                gui_modifier.setInlineStylesTheme(resourceObjectInstance);
        gui_modifier.setName("modifier");
                gui_msgErreur.setInlineStylesTheme(resourceObjectInstance);
        gui_msgErreur.setInlineAllStyles("fgColor:f01501; alignment:center;");
        gui_msgErreur.setName("msgErreur");
        gui_Box_Layout_Y.addComponent(gui_ancienMotDePasse);
        gui_Box_Layout_Y.addComponent(gui_nouveauMotDePasse);
        gui_Box_Layout_Y.addComponent(gui_nom);
        gui_Box_Layout_Y.addComponent(gui_prenom);
        gui_Box_Layout_Y.addComponent(gui_deteNaiss);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
        gui_homme.setText("Homme");
                gui_homme.setInlineStylesTheme(resourceObjectInstance);
        gui_homme.setGroup("sexe");
        gui_homme.setName("homme");
        gui_femme.setText("Femme");
                gui_femme.setInlineStylesTheme(resourceObjectInstance);
        gui_femme.setGroup("sexe");
        gui_femme.setName("femme");
        gui_Box_Layout_X.addComponent(gui_homme);
        gui_Box_Layout_X.addComponent(gui_femme);
        gui_Box_Layout_Y.addComponent(gui_email);
        gui_Box_Layout_Y.addComponent(gui_adresse);
        gui_Box_Layout_Y.addComponent(gui_modifier);
        gui_Box_Layout_Y.addComponent(gui_msgErreur);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onmodifierActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if(UserSession.getUserSession().getPassword().equals(gui_ancienMotDePasse.getText())){
        String sexe=null;
        if(gui_homme.isSelected())
            sexe="Homme";
        else if(gui_femme.isSelected())
            sexe="Femme";       
        user.setNom(gui_nom.getText());
        user.setPrenom(gui_prenom.getText());
        user.setDateNaiss(gui_deteNaiss.getDate());
        user.setSexe(sexe);
        user.setAdresse(gui_adresse.getText());
        user.setEmail(gui_email.getText());
        user.setPassword(gui_nouveauMotDePasse.getText());
        ServiceUser.modifierUser(user);
            UserSession.createUserSession(user);
        //3ef0f
        gui_msgErreur.getAllStyles().setFgColor(0x3ef0f);
        gui_msgErreur.setText("Mise à jour effectuée avec succès");
        gui_nouveauMotDePasse.setText("");
        gui_ancienMotDePasse.setText("");
        }
        else{
            gui_msgErreur.setText("Ancien mot de passe incorrect");
        }
        
    }

}
