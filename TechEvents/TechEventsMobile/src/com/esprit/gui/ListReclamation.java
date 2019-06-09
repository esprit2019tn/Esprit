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
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.Entity.Event;
import com.esprit.Entity.Reclamation;
import com.esprit.Service.ServiceEvent;
import com.esprit.Service.ServiceReclamation;
import com.esprit.TechEvents.TechEvents;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ListReclamation {

    Form f;
    ServiceReclamation es;
    ArrayList<Reclamation> lstEvt = new ArrayList<>();
    static Reclamation recStatic;

    public ListReclamation() {
        f = new Form("List des réclamation", BoxLayout.y());
        es = new ServiceReclamation();
        f.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AddEvt ad = new AddEvt();
                ad.getF().show();
            }
        });

        Container list = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                if (index == 0) {
                    lstEvt = es.getListReclamation();
                }
                if (index + amount > lstEvt.size()) {
                    amount = lstEvt.size() - index;
                }
                if (amount <= 0) {
                    return null;
                }
                Component[] elements = new Component[amount];

                int i = 0;
                int j = 1;
                for (Reclamation p : lstEvt) {
                    Label ps = new Label("                  --------" + j + "--------");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                    //Creating custom container
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.x());

                    
                    //ImageViewer photo = new ImageViewer(MyApplication.getTheme().getImage(p.getPathphoto()));
                    
                    
                    Label titre = new Label(p.getSujetReclam());
                    Label event = new Label(""+p.getEvent().getTitre());
                    Label dateLabel = new Label(p.getDateReclam());
                    
                    titre.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
                   // System.out.println(".fetchComponents()" + p.getDuree());
                    //Label date = new Label(p.getDateEvent().toString());


                    line1.add(titre);
                    line1.add(event);
                    line1.add(dateLabel);
  

                    //line1.add(cptmax);
                    //element.add(photo);
                    element.add(line1);

                    element.add(ps);

                    Button b = new Button("button");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            recStatic = p;
                            BlockReclamation blck = new BlockReclamation();
                            blck.show();
                              
                        }
                    });
                    element.setLeadComponent(b);
                    elements[i] = element;

                    //Using MultiButton
                    /*MultiButton mb = new MultiButton(p.getNom());
                    mb.setTextLine2(Integer.toString(p.getAge()));
                    mb.setTextLine3("Never show Id");
                    elements[i]=mb;*/
                    i++;
                    j++;
                }
                return elements;
            }
        };

        list.setScrollableY(false);
        f.add(list);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public static Reclamation getRecStatic() {
        return recStatic;
    }

    public static void setRecStatic(Reclamation recStatic) {
        ListReclamation.recStatic = recStatic;
    }

    

    

   

}
