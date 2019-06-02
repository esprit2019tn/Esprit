/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entity.Event;
import com.esprit.Service.ServiceEvent;
import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.esprit.TechEvents.TechEvents;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class EditEvent {

    Form f;
    ServiceEvent es;
    ArrayList<Event> lstEvt = new ArrayList<>();
    TextField titre;
    TextField capaciteMax;
    TextField capaciteMin;
    TextField duree;
    TextArea description;
    Picker dateEvt;
    Button btnajout, btninit;

    public EditEvent() {
        f = new Form(ListEvent.evtStatic.getTitre(), BoxLayout.y());
        es = new ServiceEvent();
        f.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ListEvent ad = new ListEvent();
                ad.getF().show();
                init();

            }
        });
        Container line1 = new Container(BoxLayout.x());
//        Container flowLayout = new Container();
//        flowLayout = FlowLayout.encloseIn(new Label(""),
//                btnajout, btninit);
        titre = new TextField(ListEvent.evtStatic.getTitre());
        description = new TextArea(ListEvent.evtStatic.getDesc());
        description.setRows(3);
        dateEvt = new Picker();
        try {
            dateEvt.setDate(getDate(ListEvent.evtStatic.getDateEvent()));
        } catch (Exception e) {
        };
        duree = new TextField(ListEvent.evtStatic.getDuree().toString());
        capaciteMax = new TextField(ListEvent.evtStatic.getCapaciteMax().toString());
        capaciteMin = new TextField(ListEvent.evtStatic.getCapaciteMin().toString());
        btnajout = new Button("Enregistrer");
//        btnajout.setAlignment(CENTER);
        btninit = new Button("Annuler");
//        btninit.setAlignment(CENTER);
        f.add(titre);
        f.add(dateEvt);
        f.add(duree);
        f.add(capaciteMin);
        f.add(capaciteMax);
        f.add(description);
        line1.add(btnajout);
        line1.add(btninit);
        f.add(line1);
        //  f.add(flowLayout);

        btnajout.addActionListener((e) -> {
            ServiceEvent ser = new ServiceEvent();
            Event updatedEvt = new Event();
            updatedEvt.setIdEvent(ListEvent.evtStatic.getIdEvent());
            updatedEvt.setTitre(titre.getText());
            updatedEvt.setDesc(description.getText());
            updatedEvt.setCapaciteMax(Long.parseLong(capaciteMax.getText()));
            updatedEvt.setCapaciteMin(Long.parseLong(capaciteMin.getText()));
            updatedEvt.setDuree(Long.parseLong(duree.getText()));

            ser.UpdateEvent(updatedEvt);
            Dialog.show("L'événement ", titre.getText() + " a été mis à jour", "OK", "");

        });

    }

    public void init() {
        titre = new TextField("");
        description = new TextArea("");
        dateEvt = new Picker();
        duree = new TextField("");
        capaciteMax = new TextField("");
        capaciteMin = new TextField("");
    }

    public Date getDate(String dateS) throws Exception {
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        Date r = date1.parse(dateS);
        System.out.println("com.mycompany.gui.EditEvent.getDate()" + dateS);

        return r;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
