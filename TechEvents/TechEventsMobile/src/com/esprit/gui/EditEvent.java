/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entity.*;
import com.esprit.Service.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.EAST;
import static com.codename1.ui.CN.NORTH;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.spinner.Picker;
import com.esprit.Metier.UserSession;
import com.esprit.TechEvents.TechEvents;
import static com.esprit.gui.ListEvent.evtStatic;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class EditEvent {

    Form f;
    ServiceEvent es;
    ServiceSponsor ss;
    ArrayList<Sponsor> lstSpr = new ArrayList<>();
    ArrayList<Sponsor> selecterdSpr = new ArrayList<>();

    TextField titre;
    Label titrelabel;
    TextField capaciteMax;
    Label capaciteMaxlabel;
    TextField capaciteMin;
    Label capaciteMinlabel;
    TextField duree;
    Label dureelabel;
    TextField statut;
    Label statutlabel;
    TextArea description;
    Label descriptionlabel;
    TextArea listsponsor;
    Label lstsponsors;
    Label datelabel;
    Picker dateEvt;
    Label dateEvtlabel;
    Button btnajout, btninit, btnterminer, btnreclam, btnaddSponsor, btnsavespr;
    ImageViewer img;
    private String sts;
    User u;

    public EditEvent() {
        f = new Form(ListEvent.evtStatic.getTitre(), BoxLayout.y());
        es = new ServiceEvent();
        ss = new ServiceSponsor();

        if (UserSession.verifUserSession()) {
            u = UserSession.getUserSession();
        }
        f.getToolbar().addCommandToOverflowMenu("Réserver", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (es.userIsReserved(ListEvent.evtStatic.getIdEvent(), u.getId())) {
                    es.reserver(ListEvent.evtStatic, u.getId());
                    Dialog.show("L'événement " + ListEvent.evtStatic.getTitre(), " a été réservé à " + u.getNom(), "OK", "");
                } else {
                    Dialog.show("Erreur ", "vous avez déja réservé l'évenement " + ListEvent.evtStatic.getTitre(), "OK", "");
                }
            }
        });

        f.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ListEvent ad = new ListEvent();
                ad.getF().show();
                init();

            }
        });

//        Container flowLayout = new Container();
//        flowLayout = FlowLayout.encloseIn(new Label(""),
//                btnajout, btninit);
        titrelabel = new Label("Titre  ");
        lstsponsors = new Label("Liste des sponsors");
        capaciteMaxlabel = new Label("Max   ");
        capaciteMinlabel = new Label("Min    ");
        dureelabel = new Label("Durée");
        statutlabel = new Label("Statut");
        descriptionlabel = new Label("Description");
        datelabel = new Label("Date  ");
        titre = new TextField(ListEvent.evtStatic.getTitre());
        description = new TextArea(ListEvent.evtStatic.getDesc());
        description.setRows(3);
        img = new ImageViewer();
        duree = new TextField(ListEvent.evtStatic.getDuree().toString());
        capaciteMax = new TextField(ListEvent.evtStatic.getCapaciteMax().toString());
        capaciteMin = new TextField(ListEvent.evtStatic.getCapaciteMin().toString());
        statut = new TextField(ListEvent.evtStatic.getStatut().toString());

        ImageViewer nameLabel = new ImageViewer();
        EncodedImage placeholder = EncodedImage.createFromImage(TechEvents.getTheme().getImage("img1.jpg"), true);
        URLImage uRLImage = URLImage.createToStorage(placeholder,
                ListEvent.evtStatic.getPathphoto(),
                "http://127.0.0.1/image/" + ListEvent.evtStatic.getPathphoto());
        nameLabel.setImage(uRLImage);
        img.setImage(uRLImage);
        dateEvt = new Picker();
        try {
            dateEvt.setDate(getDate(ListEvent.evtStatic.getDateEvent()));
        } catch (Exception e) {
        };

        Container line1 = new Container(BoxLayout.y());
        Container line2 = new Container(BoxLayout.x());
        Container titreContainer = new Container(BoxLayout.x());
        titreContainer.add(titrelabel);
        titreContainer.add(titre);
        Container cptmaxContainer = new Container(BoxLayout.x());
        cptmaxContainer.add(capaciteMaxlabel);
        cptmaxContainer.add(capaciteMax);
        Container cptminContainer = new Container(BoxLayout.x());
        cptminContainer.add(capaciteMinlabel);
        cptminContainer.add(capaciteMin);
        Container dureeContainer = new Container(BoxLayout.x());
        dureeContainer.add(dureelabel);
        dureeContainer.add(duree);
        Container statutContainer = new Container(BoxLayout.x());
        statutContainer.add(statutlabel);
        statutContainer.add(statut);
        Container dateContainer = new Container(BoxLayout.x());
        dateContainer.add(datelabel);
        dateContainer.add(dateEvt);

        List<Sponsor> lstsponsrevent = new ArrayList<>();

        btnajout = new Button("Enregistrer");

//        btnajout.setAlignment(CENTER);
        btninit = new Button("Annuler");
        btnreclam = new Button("Reclamer");
        btnterminer = new Button("Terminer");
        btnsavespr = new Button("Enregistrer");

//        btninit.setAlignment(CENTER);
        btnaddSponsor = new Button("Ajouter sponsor");
        f.add(nameLabel);
        f.add(titreContainer);
        f.add(dateContainer);
        f.add(dureeContainer);
        f.add(cptmaxContainer);
        f.add(cptminContainer);
        f.add(statutContainer);
        f.add(descriptionlabel);
        f.add(description);

        if (!ss.getListSponsorByEvent(evtStatic).isEmpty() && ss.getListSponsorByEvent(evtStatic) != null) {
            lstsponsrevent = ss.getListSponsorByEvent(evtStatic);
            String a = "" + lstsponsrevent;
            listsponsor = new TextArea(a);
            listsponsor.setRows(3);
            f.add(lstsponsors);
            f.add(listsponsor);
        }

        // f.add(listsponsor);
        //line2.add(btnreclam);
        if (u.getRole().equals(u.getRole().Admin)) {
            line1.add(btnajout);
            line2.add(btninit);
            line2.add(btnreclam);
            line2.add(btnterminer);
            line1.add(btnaddSponsor);
            f.add(line1);
            f.add(line2);
        }

        if (u.getRole().equals(u.getRole().SimpleUser)) {
            f.add(btnreclam);
            titre.setEditable(false);
        description.setEditable(false);
        listsponsor.setEditable(false);
        duree.setEditable(false);
        capaciteMax.setEditable(false);
        capaciteMin.setEditable(false);
        statut.setEditable(false);
        }
        //  f.add(flowLayout);

        btnaddSponsor.addActionListener((e) -> {
            Form sponsorform = new Form();
            Container list = new InfiniteContainer() {
                @Override
                public Component[] fetchComponents(int index, int amount) {
                    if (index == 0) {
                        lstSpr = ss.getListSponsor();
                    }
                    if (index + amount > lstSpr.size()) {
                        amount = lstSpr.size() - index;
                    }
                    if (amount <= 0) {
                        return null;
                    }
                    Component[] elements = new Component[amount];

                    int i = 0;
                    int j = 1;
                    for (Sponsor p : lstSpr) {
                        Label ps = new Label("            --------" + j + "--------");
                        ps.getAllStyles().set3DText(true, true);
                        ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                        //Creating custom container
                        Container element = new Container(BoxLayout.y());
                        Container line1 = new Container(BoxLayout.x());
                        Container line2 = new Container(BoxLayout.x());
                        Label titre = new Label(p.getName());
                        CheckBox chb = new CheckBox();
                        titre.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
                        System.out.println(".fetchComponents()" + p.getDomaine());
                        Label date = new Label(p.getDomaine().toString());
                        Label duree = new Label(p.getOrigine().toString());

                        chb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                System.out.println(".actionPerformed()" + p.getName());
                                if (!selecterdSpr.contains(p)) {
                                    selecterdSpr.add(p);
                                }
                                System.out.println(".actionPerformed()" + selecterdSpr);
                                if (!chb.isSelected()) {
                                    System.out.println("Not selected");
                                    selecterdSpr.remove(p);
                                }
                            }
                        });

                        line1.add(titre);
                        line1.add(duree);
                        line1.add(date);
                        line2.add(chb);
                        //line1.add(cptmax);
                        //element.add(photo);
                        element.add(line1);
                        element.add(line2);
                        //element.add(chb);
                        element.add(ps);
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

            btnsavespr.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    Container ln1 = new Container(BoxLayout.x());
                    String lstspr = "" + selecterdSpr;
                    listsponsor = new TextArea(lstspr);
                    listsponsor.setRows(3);
                    listsponsor.setEditable(false);
                    line1.removeAll();
                    line2.removeAll();
                    titreContainer.removeAll();
                    dateContainer.removeAll();
                    dureeContainer.removeAll();
                    cptmaxContainer.removeAll();
                    cptminContainer.removeAll();
                    statutContainer.removeAll();
                    titreContainer.add(titrelabel);
                    titreContainer.add(titre);
                    cptmaxContainer.add(capaciteMaxlabel);
                    cptmaxContainer.add(capaciteMax);
                    cptminContainer.add(capaciteMinlabel);
                    cptminContainer.add(capaciteMin);
                    dureeContainer.add(dureelabel);
                    dureeContainer.add(duree);
                    statutContainer.add(statutlabel);
                    statutContainer.add(statut);
                    dateContainer.add(datelabel);
                    dateContainer.add(dateEvt);
                    f.removeAll();
                    f.add(nameLabel);
                    f.add(titreContainer);
                    f.add(dateContainer);
                    f.add(dureeContainer);
                    f.add(cptmaxContainer);
                    f.add(cptminContainer);
                    f.add(statutContainer);
                    f.add(description);
                    f.add(listsponsor);
                    ln1.add(btnreclam);
                    ln1.add(btninit);
                    ln1.add(btnterminer);

                    f.add(btnajout);
                    f.add(btnaddSponsor);
                    f.add(ln1);
                    f.show();
                }
            });

            list.setScrollableY(false);
            sponsorform.add(list);
            sponsorform.add(btnsavespr);
            sponsorform.show();
        });

      //  line1.add(btnajout);
       // line1.add(btninit);
     //   line1.add(btnajoutrec);
//        f.add(line1);
        //  f.add(flowLayout);

//         btnajoutrec.addActionListener((e) -> {
//             addReclam adr = new addReclam();
//             adr.show();
//         });
        
        btnajout.addActionListener((e) -> {
            try {
                ServiceEvent ser = new ServiceEvent();
                ServiceSponsor ssr = new ServiceSponsor();
                Event updatedEvt = new Event();
                updatedEvt.setIdEvent(ListEvent.evtStatic.getIdEvent());
                updatedEvt.setTitre(titre.getText());
                updatedEvt.setDesc(description.getText());
                updatedEvt.setCapaciteMax(Long.parseLong(capaciteMax.getText()));
                updatedEvt.setCapaciteMin(Long.parseLong(capaciteMin.getText()));
                updatedEvt.setDuree(Long.parseLong(duree.getText()));
                updatedEvt.setDateEvent(getDate1(dateEvt.getText()));
                updatedEvt.setStatut(statut.getText());
                String msg = "";
                Date r = getDate(getDate2(dateEvt.getText()));
                Date s = getDate(ListEvent.evtStatic.getDateEvent());
                if (r.getTime() > s.getTime()) {
                    updatedEvt.setStatut("Reporté");
                    msg = " et reporté à " + getDate1(dateEvt.getText());
                }
                System.out.println("com.esprit.gui.EditEvent.<init>()" + sts);
                ser.UpdateEvent(updatedEvt);
                if (selecterdSpr != null && !selecterdSpr.isEmpty()) {
                    ssr.deletesponsorToevent(evtStatic);
                    ssr.addsponsorToevent(evtStatic, selecterdSpr);
                }
                Dialog.show("L'événement ", titre.getText() + " a été mis à jour " + msg, "OK", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btninit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                ServiceSponsor ssr = new ServiceSponsor();
                Event updatedEvt = new Event();
                updatedEvt.setIdEvent(ListEvent.evtStatic.getIdEvent());
                updatedEvt.setTitre(titre.getText());
                updatedEvt.setDesc(description.getText());
                updatedEvt.setCapaciteMax(Long.parseLong(capaciteMax.getText()));
                updatedEvt.setCapaciteMin(Long.parseLong(capaciteMin.getText()));
                updatedEvt.setDuree(Long.parseLong(duree.getText()));
                updatedEvt.setStatut("Annulé");
                System.out.println("com.esprit.gui.EditEvent.<init>()" + sts);
                ser.UpdateEvent(updatedEvt);
                Dialog.show("L'événement ", titre.getText() + " a été annulé", "OK", "");

            }
        });

        btnterminer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                ServiceSponsor ssr = new ServiceSponsor();
                Event updatedEvt = new Event();
                updatedEvt.setIdEvent(ListEvent.evtStatic.getIdEvent());
                updatedEvt.setTitre(titre.getText());
                updatedEvt.setDesc(description.getText());
                updatedEvt.setCapaciteMax(Long.parseLong(capaciteMax.getText()));
                updatedEvt.setCapaciteMin(Long.parseLong(capaciteMin.getText()));
                updatedEvt.setDuree(Long.parseLong(duree.getText()));
                updatedEvt.setStatut("Terminé");
                System.out.println("com.esprit.gui.EditEvent.<init>()" + sts);
                ser.UpdateEvent(updatedEvt);
                Dialog.show("L'événement ", titre.getText() + " a été annulé ", "OK", "");

            }
        });

        btnreclam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    Date r = getDate(getDate1(dateEvt.getText()));
                    Date s = getDate(ListEvent.evtStatic.getDateEvent());
                    if (r.getTime() > s.getTime()) {
                        Dialog.show("L'événement Reporté", getDate(getDate1(dateEvt.getText())) + " a été annulé", "OK", "");
                    }
                } catch (Exception d) {
                    d.printStackTrace();
                };
            }
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
        System.out.println(r + "com.mycompany.gui.EditEvent.getDate()" + dateS);

        return r;
    }

    public String getDate1(String Date) {
        String Day = Date.substring(0, 2);
        String Month = Date.substring(3, 5);
        String Year = Date.substring(6, 8);
        String newDate = /*"20" + */ Year + "-" + Month + "-" + Day;
        System.out.println("com.mycompany.gui.AddEvt.getDate()" + newDate);
        return newDate;
    }

    public String getDate2(String Date) {
        String Day = Date.substring(0, 2);
        String Month = Date.substring(3, 5);
        String Year = Date.substring(6, 8);
        String newDate = "20" + Year + "-" + Month + "-" + Day;
        System.out.println("com.mycompany.gui.AddEvt.getDate()" + newDate);
        return newDate;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void setlst(ArrayList<Sponsor> lsp) {
        selecterdSpr = lsp;
    }

}
