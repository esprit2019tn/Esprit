/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.*;
import static com.codename1.ui.CN1Constants.GALLERY_IMAGE;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.Entity.Event;
import com.esprit.Service.ServiceEvent;
import com.esprit.TechEvents.TechEvents;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AddEvt {

    Form f;
    private Resources theme;
    TextField titre;
    TextArea tedesctat;
    TextField capaciteMax;
    TextField capaciteMin;
    TextField duree;
    Picker dateEvt;
    Button btnajout, btnaff, btnaddimg;
    ImageViewer img;
    String file;
    ArrayList<Event> persons = new ArrayList<>();
    String pathimg = "";

    public AddEvt() {
        try {
            f = new Form("Créer événement", BoxLayout.y());
            titre = new TextField("", "titre");
            tedesctat = new TextArea("");
            tedesctat.setRows(3);
            tedesctat.setHint("Description");
            dateEvt = new Picker();
            duree = new TextField("", "duree");
            capaciteMax = new TextField("","capaciteMax");
            capaciteMin = new TextField("", "capaciteMin");
            btnajout = new Button("Ajouter");
            btnaff = new Button("Annuler");
            btnaddimg = new Button("Choisir image");

            initialiser();
            
            f.add(titre);
            f.add(dateEvt);
            f.add(duree);
            f.add(capaciteMin);
            f.add(capaciteMax);
            f.add(tedesctat);
            f.add(btnajout);
            f.add(btnaff);
            f.add(btnaddimg);

            f.getToolbar().addMaterialCommandToLeftSideMenu("Liste évenements", FontImage.MATERIAL_HOME, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ListEvent tse = new ListEvent();
                    tse.getF().show();
                }
            });
            
            f.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form home = new Form();
                    home.setTitle("Accueil");
                    Menu.getMenu(home);
                    home.show();
                }
            });

            btnaff.addActionListener((e) -> {
                Event evt = new Event(Long.parseLong(capaciteMax.getText()));
                System.out.println("com.mycompany.gui.AddEvent.<init>()" + capaciteMax);
            });

            btnaddimg.addActionListener((e) -> {

                Form fo = new Form();
                Container list = new InfiniteContainer() {
                    @Override
                    public Component[] fetchComponents(int index, int amount) {
                        if (index == 0) {
                            persons = getPersons();
                        }
                        if (index + amount > persons.size()) {
                            amount = persons.size() - index;
                        }
                        if (amount <= 0) {
                            return null;
                        }
                        Component[] elements = new Component[amount];

                        int i = 0;

                        for (Event p : persons) {

                            //Creating custom container
                            Container element = new Container(BoxLayout.y());
                            Container line1 = new Container(BoxLayout.x());
                           // ImageViewer nameLabel = new ImageViewer(MyApplication.getTheme().getImage(p.getTitre()));
                            
                                   ImageViewer nameLabel = new ImageViewer();
                            EncodedImage placeholder = EncodedImage.createFromImage(TechEvents.getTheme().getImage("img1.jpg"), true);
                            URLImage uRLImage = URLImage.createToStorage(placeholder,
                                     p.getTitre(),
                                     "http://127.0.0.1/image/"+p.getTitre());

                            nameLabel.setImage(uRLImage);
                            
                            Label ageLabel = new Label(p.getTitre());

                            line1.add(nameLabel);
                            line1.add(ageLabel);
                            element.add(line1);

                            Label ps = new Label("            -----");
                            ps.getAllStyles().set3DText(true, true);
                            ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));

                            element.add(ps);

                            Button b = new Button("button");
                            b.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    Dialog.show("Image", "" + p.getTitre() + " a été séléctionnée", "ok", "");
                                    //    img = new ImageViewer(MyApplication.getTheme().getImage(p.getTitre()));
                                    pathimg = p.getTitre();
                                    f.showBack();

                                    //img = new ImageViewer(MyApplication.getTheme().getImage(pathimg).scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 2)));
                                    
                                     EncodedImage placeholder = EncodedImage.createFromImage(TechEvents.getTheme().getImage("img1.jpg"), true);
                                     URLImage uRLImage = URLImage.createToStorage(placeholder,
                                     pathimg,"http://127.0.0.1/image/"+pathimg);
                                     ImageViewer yimg = new ImageViewer(uRLImage);
                                    //img.setImage(uRLImage);
                                    
                                    //img.setImageInitialPosition(CENTER);
                                    System.out.println(".actionPerformed()" + pathimg);
                                    f.removeAll();
                                    f.add(yimg);
                                    f.add(titre);
                                    f.add(dateEvt);
                                    f.add(duree);
                                    f.add(capaciteMin);
                                    f.add(capaciteMax);
                                    f.add(tedesctat);
                                    f.add(btnajout);
                                    f.add(btnaff);
                                    f.add(btnaddimg);
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

                        }
                        return elements;
                    }
                };
                fo.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
//                        img = new ImageViewer(TechEvents.getTheme().getImage(pathimg).scaledWidth(Math.round(Display.getInstance().getDisplayWidth() / 2)));
//                        System.out.println(".actionPerformed()" + pathimg);
//                        f.removeAll();
//
//                        f.add(titre);
//                        f.add(dateEvt);
//                        f.add(duree);
//                        f.add(capaciteMin);
//                        f.add(capaciteMax);
//                        f.add(img);
//                        f.add(tedesctat);
//                        f.add(btnajout);
//                        f.add(btnaff);
//                        f.add(btnaddimg);
                        f.showBack();
                    }
                });
                list.setScrollableY(false);
                fo.add(list);
                fo.show();
            });

            btnajout.addActionListener((e) -> {
                ServiceEvent ser = new ServiceEvent();
                if(notEmptyData()){
                Event evt = new Event(titre.getText().toString(), tedesctat.getText().toString(),
                        Long.parseLong(capaciteMax.getText().toString()), Long.parseLong(capaciteMin.getText().toString()),
                        Long.parseLong(duree.getText().toString()));
                evt.setPathphoto(pathimg);
                evt.setDateEvent(getDate(dateEvt.getText()));
                Long h = Long.parseLong(capaciteMax.getText());
                Event ev = new Event(Long.parseLong(capaciteMax.getText()));
                System.out.println("com.mycompany.gui.AddEvent.<init>()" + dateEvt.getText());
                if(pathimg != null && !pathimg.equals("") && !pathimg.isEmpty()){
                ser.ajoutTask(evt);
                Dialog.show("L'événement ", titre.getText() + " a été créé", "OK", "");
                init();
                }
                }
                // EventDao evd = new EventDao();
                // evd.insertImage(evt);
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    public boolean notEmptyData(){
                if(titre == null || titre.getText().equals("")){
                  Dialog.show("Le titre de l'événement est vide", "Veuillez choisir un titre", "OK", "");
                  return false ;
                }
                if(duree.getText() == null || duree.getText().equals("")){
                  Dialog.show("La durée de l'événement est vide", "Veuillez choisir une durée", "OK", "");
                  return false ;
                }
                if(pathimg == null || pathimg.equals("")){
                  Dialog.show("L'image de l'événement est vide", "Veuillez choisir une image", "OK", "");
                  return false ;
                }
                if(capaciteMin == null || capaciteMin.getText().equals("")){
                  Dialog.show("La capaciteMin de l'événement est vide", "Veuillez choisir une capaciteMin", "OK", "");
                  return false ;
                }
                if(capaciteMax == null || capaciteMax.getText().equals("")){
                  Dialog.show("La capaciteMax de l'événement est vide", "Veuillez choisir une capaciteMax", "OK", "");
                  return false ;
                }
                
        return true ;
    }

    public void init() {
        img = new ImageViewer();
        titre.setText("");
        tedesctat.setText("");
        dateEvt = new Picker();
        duree.setText("");
        capaciteMax.setText("");
        capaciteMin.setText("");
    }
    
    public void initialiser(){
        titre.setText("");
        tedesctat.setText("");
        duree.setText("");
        capaciteMax.setText("");
        capaciteMin.setText("");
    }

    public String getDate(String Date) {
        String Day = Date.substring(0, 2);
        String Month = Date.substring(3, 5);
        String Year = Date.substring(6, 8);
        String newDate = /*"20" + */ Year + "-" + Month + "-" + Day;
        System.out.println("com.mycompany.gui.AddEvt.getDate()" + newDate);
        return newDate;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTitre() {
        return titre;
    }

    public void setTitre(TextField titre) {
        this.titre = titre;
    }

    public TextArea getTedesctat() {
        return tedesctat;
    }

    public void setTedesctat(TextField tedesctat) {
        this.tedesctat = tedesctat;
    }

    public TextField getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(TextField capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public TextField getCapaciteMin() {
        return capaciteMin;
    }

    public void setCapaciteMin(TextField capaciteMin) {
        this.capaciteMin = capaciteMin;
    }

    public TextField getDuree() {
        return duree;
    }

    public void setDuree(TextField duree) {
        this.duree = duree;
    }

    public Picker getDateEvt() {
        return dateEvt;
    }

    public void setDateEvt(Picker dateEvt) {
        this.dateEvt = dateEvt;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }

    public ArrayList<Event> getPersons() {
        persons.add(new Event("evt1", "img1.jpg"));
        persons.add(new Event("evt2", "img2.jpg"));
        persons.add(new Event("evt3", "img3.jpg"));
        persons.add(new Event("evt3", "img4.jpg"));
        return persons;
    }

    public void setPersons(ArrayList<Event> persons) {
        this.persons = persons;
    }

}
