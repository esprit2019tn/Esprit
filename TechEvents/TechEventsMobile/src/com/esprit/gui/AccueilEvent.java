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
public class AccueilEvent extends com.codename1.ui.Form {

    public AccueilEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
         Menu.getMenu(this);
                 ListEvent tse = new ListEvent();
                    tse.getF().show();

    }
    
    public AccueilEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
            ListEvent tse = new ListEvent();
                    tse.getF().show();
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AccueilEvent");
        setName("AccueilEvent");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
