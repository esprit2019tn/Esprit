/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.TechEvents;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class Inscription extends com.codename1.ui.Form {

    public Inscription() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Inscription(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextField gui_TextField = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    protected com.codename1.ui.spinner.Picker gui_Picker = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.RadioButton gui_homme = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_femme = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextField gui_email = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_adresse = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_motDePasse = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_ConfMotDePasse = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Inscrire = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Inscription");
        setName("Inscription");
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("57.142857mm 76.190475mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_TextField);
        gui_Box_Layout_Y.addComponent(gui_Text_Field);
        gui_Box_Layout_Y.addComponent(gui_Picker);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
        gui_Box_Layout_X.setScrollableX(false);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Box_Layout_X.addComponent(gui_homme);
        gui_Box_Layout_X.addComponent(gui_femme);
        gui_homme.setText("Homme");
        gui_homme.setUIID("RadioButton");
                gui_homme.setInlineStylesTheme(resourceObjectInstance);
        gui_homme.setGroup("sexe");
        gui_homme.setName("homme");
        gui_femme.setText("Femme");
        gui_femme.setUIID("RadioButton");
                gui_femme.setInlineStylesTheme(resourceObjectInstance);
        gui_femme.setGroup("sexe");
        gui_femme.setName("femme");
        gui_Box_Layout_Y.addComponent(gui_email);
        gui_Box_Layout_Y.addComponent(gui_adresse);
        gui_Box_Layout_Y.addComponent(gui_motDePasse);
        gui_Box_Layout_Y.addComponent(gui_ConfMotDePasse);
        gui_Box_Layout_Y.addComponent(gui_Inscrire);
        gui_TextField.setHint("Nom");
                gui_TextField.setInlineStylesTheme(resourceObjectInstance);
        gui_TextField.setName("TextField");
        gui_Text_Field.setHint("Prenom");
        gui_Text_Field.setText("");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setName("Text_Field");
        gui_Picker.setText("...");
                gui_Picker.setInlineStylesTheme(resourceObjectInstance);
        gui_Picker.setName("Picker");
        gui_Picker.setType(4);
        gui_Box_Layout_X.setScrollableX(false);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_email.setHint("Email");
        gui_email.setText("");
        gui_email.setUIID("TextField");
                gui_email.setInlineStylesTheme(resourceObjectInstance);
        gui_email.setName("email");
        gui_adresse.setHint("Adresse");
        gui_adresse.setText("");
        gui_adresse.setUIID("TextField");
                gui_adresse.setInlineStylesTheme(resourceObjectInstance);
        gui_adresse.setName("adresse");
        gui_motDePasse.setHint("Mot De Passe");
        gui_motDePasse.setText("");
        gui_motDePasse.setUIID("TextField");
                gui_motDePasse.setInlineStylesTheme(resourceObjectInstance);
        gui_motDePasse.setName("motDePasse");
        gui_ConfMotDePasse.setHint("Confirmation Mot De Passe");
        gui_ConfMotDePasse.setText("");
        gui_ConfMotDePasse.setUIID("TextField");
                gui_ConfMotDePasse.setInlineStylesTheme(resourceObjectInstance);
        gui_ConfMotDePasse.setName("ConfMotDePasse");
        gui_Inscrire.setText("S'inscrire");
        gui_Inscrire.setUIID("Button");
                gui_Inscrire.setInlineStylesTheme(resourceObjectInstance);
        gui_Inscrire.setName("Inscrire");
        gui_Box_Layout_Y.setPreferredSizeStr("57.142857mm 76.190475mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
