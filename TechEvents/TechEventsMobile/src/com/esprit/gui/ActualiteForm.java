/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entity.Actualite;
import com.esprit.Entity.Event;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.validation.Constraint;
import com.codename1.ui.validation.Validator;
import com.esprit.Service.ServiceActualite;
import com.esprit.TechEvents.TechEvents;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alaa
 */
public class ActualiteForm {

    ArrayList<Event> list = new ArrayList<>();
    ArrayList<Actualite> listActu = new ArrayList<>();
    ServiceActualite serAct = new ServiceActualite();
    TechEvents t=new TechEvents();
Menu mn = new Menu();
    public ActualiteForm() {
        list = serAct.parseListEventJson(serAct.getEventJson());
        listActu = serAct.parseListActuJson(serAct.getActuJson());
    }

    public void showForm(Form back) {
                list = serAct.parseListEventJson(serAct.getEventJson());
        listActu = serAct.parseListActuJson(serAct.getActuJson());
        Form hi = new Form("Nouvelle Actualte", new BoxLayout(BoxLayout.Y_AXIS));
        /*hi.getToolbar().addCommandToRightBar("Back", null, e -> {
            back.showBack();
        });*/

        Label lab1 = new Label("Evenement :");
        ComboBox<Map<String, Object>> combo = new ComboBox<>();
        for (Event e : list) {
            combo.addItem(createListEntry(e.getTitre(), e.getDateEvent()));
        }

        combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));
        hi.add(lab1);
        hi.add(combo);
        Label lab2 = new Label("Description :");
        hi.add(lab2);
        TextArea desc = new TextArea(10, 20);
        hi.add(desc);
        Validator val = new Validator();
        val.addConstraint(desc, new Constraint() {
            @Override
            public boolean isValid(Object value) {
                String str = (String) value;
                if (str.length() >= 10) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDefaultFailMessage() {
                return "au moins 10 caracteres";
            }

        });
        Label lab3 = new Label(" ");
        hi.add(lab3);
        Button btn = new Button("Ajouter");
        hi.add(btn);
        btn.addActionListener(l -> {
            if (val.isValid()) {
                lab3.setText("");
            } else {
                lab3.setText(val.getErrorMessage(desc));
            }
            Event e = list.get(combo.getSelectedIndex());
            Actualite a = new Actualite(new Date(), desc.getText(), e.getIdEvent());
            System.out.println(serAct.d2s(a.getDateActu()));
            serAct.AjouterActualite(a);
            //showList(mn.);
        });
        hi.show();
    }

    public void showList(Form back) {
                list = serAct.parseListEventJson(serAct.getEventJson());
        listActu = serAct.parseListActuJson(serAct.getActuJson());
        Form showActu = new Form("Actualte", new BoxLayout(BoxLayout.Y_AXIS));
        /*showActu.getToolbar().addCommandToRightBar("Back", null, e -> {
            back.showBack();
        });*/
        System.out.println(listActu.toString());
        for (Actualite a : listActu) {
            Container c1 = new Container(BoxLayout.y());
            Container c2 = new Container(BoxLayout.x());
            Label event = new Label("Evenement: " + findEvent(a.getEventId()).getTitre());
            Label dat = new Label("Date: " + serAct.d2s(a.getDateActu()));
            Label des = new Label("Dsecription: " + a.getDesc());
            c2.add(event).add(dat);
            c1.add(c2).add(des);
            showActu.add(c1);
        }
        Button btn = new Button("Ajouter");
        btn.addActionListener(e -> {
            showForm(showActu);
        });
        showActu.add(btn);
        showActu.show();

    }

    private Map<String, Object> createListEntry(String name, String date) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", date);
        return entry;
    }

    public Event findEvent(int id) {

        for (Event event : list) {
            if (event.getIdEvent() == id) {
                return event;
            }
        }
        return new Event();
    }
}
