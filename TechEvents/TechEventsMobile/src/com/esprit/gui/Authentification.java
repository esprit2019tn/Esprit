/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class Authentification extends com.codename1.ui.Form {

    public Authentification() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
                Menu.getMenu(this);
    }
    
    public Authentification(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextField gui_email = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_motDePasse = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_motDePasseOublier = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_connexion = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_inscription = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_connexion.addActionListener(callback);
        gui_inscription.addActionListener(callback);
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

            if(sourceComponent == gui_connexion) {
                onconnexionActionEvent(ev);
            }
            if(sourceComponent == gui_inscription) {
                oninscriptionActionEvent(ev);
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
        setTitle("Authentification");
        setName("Authentification");
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("82.80423mm 39.15344mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_email);
        gui_Box_Layout_Y.addComponent(gui_motDePasse);
        gui_Box_Layout_Y.addComponent(gui_motDePasseOublier);
        gui_Box_Layout_Y.addComponent(gui_connexion);
        gui_Box_Layout_Y.addComponent(gui_Label);
        gui_Box_Layout_Y.addComponent(gui_inscription);
        gui_email.setHint("Email");
                gui_email.setInlineStylesTheme(resourceObjectInstance);
        gui_email.setName("email");
        gui_email.setConstraint(com.codename1.ui.TextArea.EMAILADDR);
        gui_motDePasse.setHint("Mot de passe");
                gui_motDePasse.setInlineStylesTheme(resourceObjectInstance);
        gui_motDePasse.setName("motDePasse");
        gui_motDePasse.setConstraint(com.codename1.ui.TextArea.PASSWORD);
        gui_motDePasseOublier.setText("Mot de passe oublier ?");
                gui_motDePasseOublier.setInlineStylesTheme(resourceObjectInstance);
        gui_motDePasseOublier.setName("motDePasseOublier");
        gui_connexion.setText("Connexion");
                gui_connexion.setInlineStylesTheme(resourceObjectInstance);
        gui_connexion.setName("connexion");
        gui_Label.setText("-Ou-");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
        gui_inscription.setText("Inscription");
                gui_inscription.setInlineStylesTheme(resourceObjectInstance);
        gui_inscription.setName("inscription");
        gui_Box_Layout_Y.setPreferredSizeStr("82.80423mm 39.15344mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onconnexionActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void oninscriptionActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

}
