/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.esprit.Entity.Reclamation;
import com.esprit.Metier.UserSession;
import com.esprit.Service.ServiceReclamation;

/**
 * GUI builder created Form
 *
 * @author dhiae
 */
public class addReclam extends com.codename1.ui.Form {

    public addReclam() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public addReclam(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_Label.setText("Réclamation de l'événement "+ListEvent.getEvtStatic().getTitre());
        this.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ListEvent ad = new ListEvent();
                ad.getF().show();
            }
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    protected com.codename1.ui.TextField gui_Sujet  = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextArea gui_Explication = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
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
        setTitle("addReclam");
        setName("addReclam");
        gui_Button.setPreferredSizeStr("187.30159mm 8.465609mm");
        gui_Button.setText("R\u00E9clamer l'\u00E9venement");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Sujet .setPreferredSizeStr("187.30159mm inherit");
        gui_Sujet .setHint("Sujet");
                gui_Sujet .setInlineStylesTheme(resourceObjectInstance);
        gui_Sujet .setName("Sujet ");
        gui_Sujet .setColumns(20);
        gui_Explication.setPreferredSizeStr("187.30159mm 37.56614mm");
        gui_Explication.setHint("Explication");
                gui_Explication.setInlineStylesTheme(resourceObjectInstance);
        gui_Explication.setName("Explication");
        gui_Explication.setColumns(8);
        gui_Explication.setRows(1);
        gui_Label.setPreferredSizeStr("188.35979mm 11.904762mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("transparency:24; opacity:18;");
        gui_Label.setName("Label");
        addComponent(gui_Button);
        addComponent(gui_Sujet );
        addComponent(gui_Explication);
        addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "2.1164005mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Button, "2 1 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Sujet .getParent().getLayout()).setInsets(gui_Sujet , "10.646387% 0.0mm auto 0.0mm").setReferenceComponents(gui_Sujet , "-1 -1 -1 -1").setReferencePositions(gui_Sujet , "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Explication.getParent().getLayout()).setInsets(gui_Explication, "-1.3227513mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Explication, "1 1 -1 -1").setReferencePositions(gui_Explication, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "1.5873015mm auto -2.6226044E-6mm 0.0mm").setReferenceComponents(gui_Label, "-1 1 1 1 ").setReferencePositions(gui_Label, "0.0 0.0 1.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        System.out.println("----------------999999999999999999-----------------"+ListEvent.getEvtStatic().getTitre());
        ServiceReclamation src = new ServiceReclamation();
        Reclamation rcl = new Reclamation();
        
        if (gui_Sujet.getText().equals("")){
                        Dialog.show("Svp remplir le sujet ", gui_Sujet.getText() + "", "OK", "");

        }
        if (gui_Explication.getText().equals(""))
        {
            Dialog.show("Svp remplir l'expilcation ", gui_Sujet.getText() + "", "OK", "");
        }
        else
        {
        rcl.setSujetReclam(gui_Sujet.getText());
        rcl.setTextReclam(gui_Explication.getText());
        rcl.setUser(UserSession.getUserSession());
        rcl.setEvent(ListEvent.getEvtStatic());
        src.ajoutReclamation(rcl);
        Dialog.show("La réclamation ", gui_Sujet.getText() + " a été ajouté", "OK", "");
                
        
                                

}}}
