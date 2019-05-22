package com.esprit.TechEvents;


import static com.codename1.ui.CN.*;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class TechEvents {

    private Form current;
    private Resources theme;

    private Form home;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }

    public void start() {
       
            Form home = new Form();
        Form page1 = new Form();
        page1.add(new Label("page1"));
        page1.getToolbar().addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                home.showBack();
            }
        });
        Form page2 = new Form();
        page2.add(new Label("page2"));
        page2.getToolbar().addCommandToRightBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                home.showBack();
            }
        });
        Form page3 = new Form();
        page3.add(new Label("page3"));
        

        page3.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                home.showBack();
            }
        });

        home.add(new Label("Home"));
        home.getToolbar().addMaterialCommandToLeftSideMenu("Home", FontImage.MATERIAL_HOME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                home.showBack();
            }
        });
        home.getToolbar().addCommandToLeftSideMenu("page1", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                Inscription inscription=new Inscription();
//                inscription.setTheme(theme);
//                inscription.setHome(home);
//                inscription.getCurrent().show();
                 // Inscription.fr().show();
                  Inscription inscription = new Inscription();
                  inscription.show();
            }
        });

        home.getToolbar().addCommandToLeftSideMenu("page2", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                page2.show();
            }
        });

        home.getToolbar().addCommandToLeftSideMenu("page3", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                page3.show();
            }
        });
        page1.setToolbar(home.getToolbar());
        page2.setToolbar(home.getToolbar());
        home.show();
    }

    private void showOKForm(String name) {
        Form f = new Form("Thanks", BoxLayout.y());
        f.add(new SpanLabel("Thanks " + name + " for your submission. You can press the back arrow and try again"));
        f.getToolbar().setBackCommand("", e -> home.showBack());
        f.show();
    }
    
    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
