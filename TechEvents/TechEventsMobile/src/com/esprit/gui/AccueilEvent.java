/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Entity.Event;
import com.esprit.Service.ServiceEvent;
import com.esprit.TechEvents.TechEvents;
import static com.esprit.gui.ListEvent.evtStatic;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class AccueilEvent extends com.codename1.ui.Form {

    public AccueilEvent() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
         Menu.getMenu(this);

    }
    
    public AccueilEvent(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
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
