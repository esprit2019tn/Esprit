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
import com.esprit.Service.ServiceEvent;
import com.esprit.TechEvents.TechEvents;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ListEvent {

    Form f;
    ServiceEvent es;
    ArrayList<Event> lstEvt = new ArrayList<>();
    static Event evtStatic;

    public ListEvent() {
        f = new Form("List des événements", BoxLayout.y());
        es = new ServiceEvent();
        f.getToolbar().addCommandToOverflowMenu("Ajouter événement", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             //   AddEvent ad = new AddEvent();
              //  ad.getF().show();
            }
        });

        Container list = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                if (index == 0) {
                    lstEvt = es.getList2();
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
                for (Event p : lstEvt) {
                    Label ps = new Label("            --------" + j + "--------");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                    //Creating custom container
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.x());
                    
                    EncodedImage placeholder = EncodedImage.createFromImage(TechEvents.getTheme().getImage("img1.jpg"), true);
                                     URLImage uRLImage = URLImage.createToStorage(placeholder,
                                     p.getPathphoto(),"http://127.0.0.1/image/"+p.getPathphoto());
                                     ImageViewer yimg = new ImageViewer(uRLImage);
                    
                    //ImageViewer photo = new ImageViewer(MyApplication.getTheme().getImage(p.getPathphoto()));
                    
                    
                    Label titre = new Label(p.getTitre());
                    titre.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
                    System.out.println(".fetchComponents()" + p.getDuree());
                    Label date = new Label(p.getDateEvent().toString());
                    Label duree = new Label(p.getDuree().toString() + "J");
                    Label cptmax = new Label(p.getCapaciteMax().toString() + "Max");

                    line1.add(yimg);
                    line1.add(titre);
                    line1.add(duree);
                    line1.add(date);
                    //line1.add(cptmax);
                    //element.add(photo);
                    element.add(line1);

                    element.add(ps);

                    Button b = new Button("button");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            evtStatic = p;
                           // EditEvent edt = new EditEvent();
                           // edt.getF().show();
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

    public ServiceEvent getEs() {
        return es;
    }

    public void setEs(ServiceEvent es) {
        this.es = es;
    }

    public ArrayList<Event> getLstEvt() {
        return lstEvt;
    }

    public void setLstEvt(ArrayList<Event> lstEvt) {
        this.lstEvt = lstEvt;
    }

    public static Event getEvtStatic() {
        return evtStatic;
    }

    public static void setEvtStatic(Event evtStatic) {
        ListEvent.evtStatic = evtStatic;
    }

}
