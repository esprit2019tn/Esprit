/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entity.User;
import com.esprit.Service.ServiceUser;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class ConfirmationAdresse extends com.codename1.ui.Form {

    public ConfirmationAdresse() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ConfirmationAdresse(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_email = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_confirmationCode = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_confirmer = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_msgErreur = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_confirmer.addActionListener(callback);
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

            if(sourceComponent == gui_confirmer) {
                onconfirmerActionEvent(ev);
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
        setTitle("ConfirmationAdresse");
        setName("ConfirmationAdresse");
        gui_Label.setPreferredSizeStr("53.968254mm inherit");
        gui_Label.setText("Entrer le code de confirmation");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("transparency:21; alignment:center;");
        gui_Label.setName("Label");
        gui_email.setHint("email");
                gui_email.setInlineStylesTheme(resourceObjectInstance);
        gui_email.setName("email");
        gui_confirmationCode.setPreferredSizeStr("inherit 6.6137567mm");
        gui_confirmationCode.setHint("Code de confirmation");
                gui_confirmationCode.setInlineStylesTheme(resourceObjectInstance);
        gui_confirmationCode.setName("confirmationCode");
        gui_confirmer.setPreferredSizeStr("53.968254mm inherit");
        gui_confirmer.setText("Confirmer");
                gui_confirmer.setInlineStylesTheme(resourceObjectInstance);
        gui_confirmer.setName("confirmer");
        gui_msgErreur.setPreferredSizeStr("53.968254mm inherit");
                gui_msgErreur.setInlineStylesTheme(resourceObjectInstance);
        gui_msgErreur.setInlineAllStyles("fgColor:fe2617; alignment:center;");
        gui_msgErreur.setName("msgErreur");
        addComponent(gui_Label);
        addComponent(gui_email);
        addComponent(gui_confirmationCode);
        addComponent(gui_confirmer);
        addComponent(gui_msgErreur);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "23.574144% auto auto 35.19553%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_email.getParent().getLayout()).setInsets(gui_email, "15.0% auto auto auto").setReferenceComponents(gui_email, "0 -1 -1 -1").setReferencePositions(gui_email, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_confirmationCode.getParent().getLayout()).setInsets(gui_confirmationCode, "15.0% auto auto auto").setReferenceComponents(gui_confirmationCode, "1 -1 -1 -1").setReferencePositions(gui_confirmationCode, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_confirmer.getParent().getLayout()).setInsets(gui_confirmer, "15.0% auto auto auto").setReferenceComponents(gui_confirmer, "2 1 -1 0 ").setReferencePositions(gui_confirmer, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_msgErreur.getParent().getLayout()).setInsets(gui_msgErreur, "auto 0.0mm 7.671959mm 55.0%").setReferenceComponents(gui_msgErreur, "2 0 3 -1").setReferencePositions(gui_msgErreur, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        ServiceUser serviceUser =new ServiceUser();
        User user =serviceUser.findUserByEmail(gui_email.getText());
        
        String confCode=user.getConfirmationCode();
        if(confCode!=null){
            if(confCode.equals(gui_confirmationCode.getText())){
                ServiceUser.setConfirmationEmail(gui_email.getText());
                AccueilEvent accueilEvent =new AccueilEvent();
                accueilEvent.show();
            }
            else{
                gui_msgErreur.setText("Code de confirmation incorrecte");
            }
        }
        else{
                gui_msgErreur.setText("Email incorrecte");
        }
    }

    public void onconfirmerActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
