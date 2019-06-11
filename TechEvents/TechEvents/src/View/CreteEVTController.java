/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
import Dao.SponsorDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import Entity.Event;
import Entity.Sponsor;
import Entity.User;
import Metier.UserSession;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class CreteEVTController implements Initializable {

    @FXML
    private JFXHamburger humburger;
    @FXML
    private JFXDrawer drawer;
    private VBox vbox;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField titre;
    private ComboBox<String> lstsponsor;
    private JFXTextField ville;
    private JFXTextField adresse;
    private Spinner<Sponsor> spinner;
    @FXML
    private TextArea description;
    private ImageView img;
    @FXML
    private JFXButton Annuler;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXTextField duree;
    @FXML
    private JFXTextField capacitemax;
    @FXML
    private JFXTextField capacitemin;
    @FXML
    private ImageView myimg;
    @FXML
    private Label capacitemax1;
    @FXML
    private JFXButton btnfile;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event, Integer> clnid;
    @FXML
    private TableColumn<Event, String> clntitre;
    @FXML
    private TableColumn<Event, String> clndate;
    @FXML
    private TableColumn<Event, Integer> clnduree;
    @FXML
    private TableColumn<Event, Number> cptmax;
    @FXML
    private TableColumn<Event, Number> cptmin;
    @FXML
    private TableColumn<Event, String> clndescri;

    private boolean nav = false;
    EventDao uda = new EventDao();
    int id;
    int a = 0;
    @FXML
    private TableColumn<Event, ImageView> photo;

    Sponsor s = new Sponsor("aaa", "bbb");
    public ObservableList<Sponsor> lstspr = FXCollections.observableArrayList(s);
    @FXML
    private Label username;
    @FXML
    private JFXButton consultEVT;

    static Event selecedEvent;
    @FXML
    private TableView<Event> tableReservation;
    @FXML
    private TableColumn<Event, Integer> clnid1;
    @FXML
    private TableColumn<Event, String> clntitre1;
    @FXML
    private TableColumn<Event, String> clndate1;
    @FXML
    private TableColumn<Event, Integer> clnduree1;
    @FXML
    private TableColumn<Event, Number> cptmax1;
    @FXML
    private TableColumn<Event, Number> cptmin1;
    @FXML
    private TableColumn<Event, String> clndescri1;
    @FXML
    private TableColumn<Event, ImageView> photo1;
    @FXML
    private TableColumn<Event, String> clnstatut;
    @FXML
    private Pane menu;
    @FXML
    private Button showmenu;

    private String photoPath;

    @FXML
    private JFXTextArea autre;
    @FXML
    private JFXTextField sprfondateur;
    @FXML
    private JFXTextField sprname;
    @FXML
    private JFXTextField sprresp;
    @FXML
    private JFXTextField sprorigine;
    @FXML
    private JFXTextField sprmat;
    @FXML
    private JFXTextField sprdomaine;
    @FXML
    private JFXTextField srch;
    @FXML
    private JFXButton btnaddsponsor;
    @FXML
    private JFXButton btninitsponsor;
    @FXML
    private JFXTextField rechercheReservation;
    @FXML
    private TableColumn<Event, String> clnstatut1;
    @FXML
    private Button btnDeconnexion;
    @FXML
    private Button btnConnexion;
    @FXML
    private Button btnInscription;
    @FXML
    private Tab createEVT;
    @FXML
    private Tab AddSponsors;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            VBox vbx = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
            drawer.setSidePane(vbx);

            HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(humburger);
            transition.setRate(-1);
            humburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();

                if (drawer.isShown()) {
                    drawer.close();
                } else {
                    drawer.open();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(CreteEVTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(".handle()" + table.getSelectionModel().getSelectedItem().getTitre());
                a = table.getSelectionModel().getSelectedItem().getIdEvent();
                //            setA(table.getSelectionModel().getSelectedItem().getIdEvent());
                selecedEvent = table.getSelectionModel().getSelectedItem();
            }

        });
        capacitemax.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    capacitemax.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        User user = UserSession.getUserSession();
        if (user != null && !user.getNom().equals("")) {
            btnConnexion.setVisible(false);
            btnInscription.setVisible(false);
            btnDeconnexion.setVisible(true);
            username.setVisible(true);

        }

        if (user.getRole().equals(user.getRole().SimpleUser)) {
         //   createEVT.setDisable(true);
            AddSponsors.setDisable(true);
        }

        try {
            if (UserSession.verifUserSession()) {
                username.setText(UserSession.getUserSession().getNom() + " " + UserSession.getUserSession().getPrenom());
            }
        } catch (BackingStoreException ex) {
            Logger.getLogger(CreteEVTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Event getevt() {
        return selecedEvent;
    }
//    public void scrollable(){
//         achp1.setTranslateY(20);
//        
//        sc.setLayoutX(800-sc.getWidth());
//        sc.setMin(0);
//        sc.setOrientation(Orientation.VERTICAL);
//        sc.setPrefHeight(180);
//        sc.setMax(360);
//        
//        sc.valueProperty().addListener(event->{
//            achp1.setTranslateY(20+sc.getValue());
//        });
//    }
//        public ObservableList<Event> list = FXCollections.observableArrayList(
//                new Event("", "", Long.valueOf(3), Long.valueOf(2), "")
//                );
    public ObservableList<Event> list = FXCollections.observableArrayList();
    public ObservableList<Event> listReservation = FXCollections.observableArrayList();

    @FXML
    public void list() {
        Event e = table.getSelectionModel().getSelectedItem();
        EventDao uda = new EventDao();
        uda.updateImage();
        if (list.isEmpty()) {
            list.addAll(uda.findAll());
        }
        clnid.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));
        clnstatut.setCellValueFactory(new PropertyValueFactory<Event, String>("statut"));
        cptmin.setCellValueFactory(new PropertyValueFactory<>("capaciteMin"));
        clndescri.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));
        photo.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        //  edittable();
        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
        //  cptmax.setCellFactory(col -> new IntegerEditingCell());
        cptmax.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        cptmin.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        setStyleColumn();
//        Callback<TableColumn<Event, Number>, TableCell<Event, Number>> txtCellFactory
//                = (TableColumn<Event, Number> p) -> {
//                    System.out.println(".handlellll()");
//                    return new IntegerEditingCell();
//                };
//        cptmax.setCellFactory(new Callback<TableColumn<Event, String>, TableCell<Event, String>>() {
//            @Override
//            public TableCell<Event, String> call(TableColumn<Event, String> param) {
//                TableCell<Event,String> clc = new TableCell<>();
//                return clc ;
//            }
//        });
        //   cptmin.setCellFactory(TextFieldTableCell.forTableColumn());
        table.setEditable(true);
        table.setItems(list);
        rechercheReservation.setVisible(false);
        srch.setVisible(true);
    }

    @FXML
    private void reservationlst() {
        listReservation.clear();
        if (listReservation.isEmpty()) {
            listReservation.addAll(uda.findReservationByEvent(UserSession.getUserSession()));
        }
        clnid1.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre1.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate1.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree1.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax1.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));
        clnstatut1.setCellValueFactory(new PropertyValueFactory<Event, String>("statut"));
        cptmin1.setCellValueFactory(new PropertyValueFactory<>("capaciteMin"));
        clndescri1.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));
        photo1.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        //  edittable();
        clntitre1.setCellFactory(TextFieldTableCell.forTableColumn());
        //  cptmax.setCellFactory(col -> new IntegerEditingCell());
        cptmax1.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        cptmin1.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        tableReservation.setItems(listReservation);
        rechercheReservation.setVisible(true);
        srch.setVisible(false);

    }

    @FXML
    private void searchReservation(KeyEvent event) {
        listReservation.clear();
        if (listReservation.isEmpty()) {
            listReservation.addAll(uda.searchReservationByUser(UserSession.getUserSession(), rechercheReservation.getText()));
        }
        clnid1.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre1.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate1.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree1.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax1.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));

        cptmin1.setCellValueFactory(new PropertyValueFactory<>("capaciteMin"));
        clndescri1.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));
        photo1.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        //  edittable();
        clntitre1.setCellFactory(TextFieldTableCell.forTableColumn());
        //  cptmax.setCellFactory(col -> new IntegerEditingCell());
        cptmax1.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        cptmin1.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        tableReservation.setItems(listReservation);
    }

    @FXML
    public void edit() {
        clntitre.setOnEditStart(e -> {
            //    e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
            System.out.println("OLD----VALUE--" + e.getOldValue().toString());
        });
        System.out.println("View.CreteEVTController.edit()" + table.getSelectionModel().getSelectedItem().getIdEvent());
        a = table.getSelectionModel().getSelectedItem().getIdEvent();
        setA(table.getSelectionModel().getSelectedItem().getIdEvent());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA" + a);
    }

    public void f(String az) {
//          table.setOnMousePressed(new EventHandler<MouseEvent>(){
//                    @Override
//                    public void handle(MouseEvent event) {
//                        System.out.println(".handle()"+table.getSelectionModel().getSelectedItem().getIdEvent());
//                    }
//            
//        });
        System.out.println("View.CreteEVTController.f()" + az + "ROW" + a);
    }

    public void v(CellEditEvent c) {
        System.out.println("View.CreteEVTController.v()");
    }

    public void commit() {
        clntitre.setOnEditCommit(e -> {
            //    e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
            e.getTableView().getItems().get(e.getTablePosition().getRow()).getTitre();
            System.out.println("NEW----VALUE--" + e.getNewValue().toString());
        });
        clntitre.setOnEditCommit(new EventHandler<CellEditEvent<Event, String>>() {
            @Override
            public void handle(CellEditEvent<Event, String> event) {
                System.out.println("NEW----VALUE--" + event.getNewValue().toString());
            }
        });
        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());

        table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Selected Person: "
                        + newValue.getTitre() + " | "
                );
            }
        });
    }

    public void edittable() {

        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setEditable(true);
    }

    @FXML
    public void changeTitle(CellEditEvent cv) {
        Event e = table.getSelectionModel().getSelectedItem();
        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        System.out.println("New--Value =" + cv.getNewValue().toString() + " Event " + e.getIdEvent() + " titre " + clntitre.getCellObservableValue(row).getValue().toString());
        Event evt = new Event(clnid.getCellObservableValue(row).getValue(), cv.getNewValue().toString(), clndescri.getCellObservableValue(row).getValue().toString(),
                Long.parseLong(String.valueOf(cptmax.getCellObservableValue(row).getValue())), Long.parseLong(String.valueOf(cptmin.getCellObservableValue(row).getValue())),
                clndate.getCellObservableValue(row).getValue().toString());
        evt.setStatut(clnstatut.getCellObservableValue(row).getValue().toString());
        evt.setDuree(Long.parseLong(String.valueOf(clnduree.getCellObservableValue(row).getValue())));
        System.out.println("View.CreteEVTController.changename()" + cptmax.getCellObservableValue(row).getValue());
        uda.update(evt);
        list.clear();
        list();
    }

    @FXML
    public void changecptmax(CellEditEvent cv) {
        Event e = table.getSelectionModel().getSelectedItem();
        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        System.out.println("New--Value =" + cv.getNewValue().toString() + " Event " + e.getIdEvent() + " titre " + clntitre.getCellObservableValue(row).getValue().toString());
        Event evt = new Event(clnid.getCellObservableValue(row).getValue(), clntitre.getCellObservableValue(row).getValue().toString(), clndescri.getCellObservableValue(row).getValue().toString(),
                Long.parseLong(cv.getNewValue().toString()), Long.parseLong(String.valueOf(cptmin.getCellObservableValue(row).getValue())),
                clndate.getCellObservableValue(row).getValue().toString());
        evt.setStatut(clnstatut.getCellObservableValue(row).getValue().toString());
        evt.setDuree(Long.parseLong(String.valueOf(clnduree.getCellObservableValue(row).getValue())));

        System.out.println("View.CreteEVTController.changename()" + cptmax.getCellObservableValue(row).getValue());
        uda.update(evt);
        list.clear();
        list();
    }

    @FXML
    public void changecptmin(CellEditEvent cv) {
        Event e = table.getSelectionModel().getSelectedItem();
        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        System.out.println("New--Value =" + cv.getNewValue().toString() + " Event " + e.getIdEvent() + " titre " + clntitre.getCellObservableValue(row).getValue().toString());
        Event evt = new Event(clnid.getCellObservableValue(row).getValue(), clntitre.getCellObservableValue(row).getValue().toString(), clndescri.getCellObservableValue(row).getValue().toString(),
                Long.parseLong(String.valueOf(cptmax.getCellObservableValue(row).getValue())), Long.parseLong(String.valueOf(cv.getNewValue().toString())),
                clndate.getCellObservableValue(row).getValue().toString());
        evt.setDuree(Long.parseLong(String.valueOf(clnduree.getCellObservableValue(row).getValue())));

        System.out.println("View.CreteEVTController.changename()" + cptmax.getCellObservableValue(row).getValue());
        evt.setStatut(clnstatut.getCellObservableValue(row).getValue().toString());
        uda.update(evt);
        list.clear();
        list();
    }

    public void editable(CellEditEvent ce) {
        Event e = table.getSelectionModel().getSelectedItem();
        e.setTitre(ce.getNewValue().toString());
        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
//            clntitre.setOnEditCommit(e -> {
//                e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
//            });        
    }

    @FXML
    public void create() {
        EventDao uda = new EventDao();
        String dt = date.getValue().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        Date dateStr = null;
//        try {
//            dateStr = formatter.parse(dt);
//        } catch (ParseException ex) {
//            Logger.getLogger(CreteEVTController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        try {
            dateStr = formatter.parse(dt);
            Event evt = new Event(titre.getText(), description.getText(), Long.parseLong(duree.getText()),
                    Long.parseLong(capacitemax.getText()), Long.parseLong(capacitemin.getText()),
                    dt, myimg);
//            String h = new SimpleDateFormat("yyyy-MM-dd").format(dts);
//             Date fs = formatter.parse(h);
            System.out.println("---_______i_______-------_" + remove(new Date()));
            // uda.insert(evt);
            evt.setPhotoPath(photoPath);
            uda.inserer(evt, fl);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Evenement");
            alert.setHeaderText("Evenement crée avec succées");
            alert.setContentText("L'événement " + titre.getText() + " à été crée ");

            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
        list.clear();
    }

    @FXML
    public void delete() {
        User user = UserSession.getUserSession();
        if (user.getRole().equals(user.getRole().SimpleUser)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Evenement");
            alert.setHeaderText("Erreur");
            alert.setContentText("Vous n'avez pas le droit de supprimer un evenement");

            alert.showAndWait();
        } else {
            Event e = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            uda.delete(e.getIdEvent());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Evenement");
            alert.setHeaderText("Evenement supprimée avec succées");
            alert.setContentText("L'événement " + e.getTitre() + " à été supprimé ");

            alert.showAndWait();
            list.clear();
            list();
            System.out.println(e.getTitre());
        }
    }
    File fl;

    @FXML
    public File choosefile() {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterjpeg
                = new FileChooser.ExtensionFilter("jpeg files (*.jpeg)", "*.jpeg");
        FileChooser.ExtensionFilter extFilterJPEG
                = new FileChooser.ExtensionFilter("JPEG files (*.JPEG)", "*.JPEG");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fc.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng, extFilterjpeg, extFilterJPEG);
        fl = fc.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(fl);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            myimg.setImage(image);
            System.out.println(fl.toString());
            int lastindex = fl.toString().lastIndexOf("\\");
            int firstindex = fl.toString().length();
            System.out.println(fl.toString().substring(lastindex + 1, firstindex));
            photoPath = fl.toString().substring(lastindex + 1, firstindex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fl;
    }

    public void init() {
        titre.setText("");
        description.setText("");
        capacitemax.setText("");
        capacitemin.setText("");
        date.setValue(LocalDate.now());
    }

    public Date remove(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @FXML
    private void consultEVT(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("ConsultEVT.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = new Stage();
//  Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public JFXHamburger getHumburger() {
        return humburger;
    }

    public void setHumburger(JFXHamburger humburger) {
        this.humburger = humburger;
    }

    public JFXDrawer getDrawer() {
        return drawer;
    }

    public void setDrawer(JFXDrawer drawer) {
        this.drawer = drawer;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public DatePicker getDate() {
        return date;
    }

    public void setDate(JFXDatePicker date) {
        this.date = date;
    }

    public JFXTextField getTitre() {
        return titre;
    }

    public void setTitre(JFXTextField titre) {
        this.titre = titre;
    }

    public ComboBox<String> getLstsponsor() {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );
        final ComboBox comboBox = new ComboBox(options);
        return comboBox;
    }

    public void setLstsponsor(ComboBox<String> lstsponsor) {
        this.lstsponsor = lstsponsor;
    }

    public JFXTextField getVille() {
        return ville;
    }

    public void setVille(JFXTextField ville) {
        this.ville = ville;
    }

    public JFXTextField getAdresse() {
        return adresse;
    }

    public void setAdresse(JFXTextField adresse) {
        this.adresse = adresse;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public JFXButton getAnnuler() {
        return Annuler;
    }

    public void setAnnuler(JFXButton Annuler) {
        this.Annuler = Annuler;
    }

    public JFXButton getValider() {
        return valider;
    }

    public void setValider(JFXButton valider) {
        this.valider = valider;
    }

    public JFXTextField getCapacitemax() {
        return capacitemax;
    }

    public void setCapacitemax(JFXTextField capacitemax) {
        this.capacitemax = capacitemax;
    }

    public JFXTextField getCapacitemin() {
        return capacitemin;
    }

    public void setCapacitemin(JFXTextField capacitemin) {
        this.capacitemin = capacitemin;
    }

    public boolean isNav() {
        return nav;
    }

    public void setNav(boolean nav) {
        this.nav = nav;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @FXML
    private void splitMenu(ActionEvent event) {
        if (menu.isVisible()) {
            menu.setVisible(false);
        } else {
            menu.setVisible(true);
        }
    }
//        if(menuPane.isVisible())
//            menuPane.setVisible(false);
//        else
//            menuPane.setVisible(true);
//    }

    @FXML
    private void showEvent(ActionEvent event) {
        System.out.println("View.CreteEVTController.splitMenu()");

    }

    @FXML
    private void search(KeyEvent event) {
        System.out.println("View.CreteEVTController.search()" + srch.getText());
        list.clear();
        if (list.isEmpty()) {
            list.addAll(uda.findAllEvent(srch.getText()));
        }
        clnid.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));
        clnstatut.setCellValueFactory(new PropertyValueFactory<Event, String>("statut"));
        cptmin.setCellValueFactory(new PropertyValueFactory<>("capaciteMin"));
        clndescri.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));
        photo.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        //  edittable();
        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
        //  cptmax.setCellFactory(col -> new IntegerEditingCell());
        cptmax.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        cptmin.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        setStyleColumn();
        table.setEditable(true);
        table.setItems(list);

    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @FXML
    private void addsponsor(ActionEvent event) {
        SponsorDao spd = new SponsorDao();
        Sponsor spr = new Sponsor();
        spr.setMatricule(Integer.parseInt(sprmat.getText()));
        spr.setDesc(autre.getText());
        spr.setDomaine(sprdomaine.getText());
        spr.setFondateur(sprfondateur.getText());
        spr.setName(sprname.getText());
        spr.setOrigine(sprorigine.getText());
        spr.setResponsable(sprresp.getText());

        spd.createSpr(spr);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sponsor");
        alert.setHeaderText("Sponsor a été créer avec succées");
        alert.setContentText("Le sponsor " + sprname.getText() + " à été crée ");

        alert.showAndWait();

    }

    public void setStyleColumn() {
//        clntitre.setCellFactory(v -> new TableCell<Event, String>() {
//            @Override
//            public void updateItem(String item, boolean empty) {
//                // Always invoke super constructor.
//                super.updateItem(item, empty);
//
//                if (item == null || empty) {
//                    setText(null);
//                } else {
//                    setText(item);
//
//                    this.setStyle("-fx-text-fill: blue;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
//                }
//            }
//        });

        clnstatut.setCellFactory(v -> new TableCell<Event, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                // Always invoke super constructor.
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item);

                    if (item.equals("Annulé")) {
                        this.setStyle("-fx-text-fill: red;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Disponible")) {
                        this.setStyle("-fx-text-fill: green;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Reporté")) {
                        this.setStyle("-fx-text-fill: yellow;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Terminé")) {
                        this.setStyle("-fx-text-fill: blue;-fx-font-size: 20px;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    }

                }
            }
        });
        clntitre.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        cptmin.setStyle("-fx-text-fill: #808080	;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        cptmax.setStyle("-fx-text-fill: #808080	;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        clnduree.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        clndate.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        photo.setStyle(" -fx-alignment: center ;");

        clnstatut1.setCellFactory(v -> new TableCell<Event, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                // Always invoke super constructor.
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item);

                    if (item.equals("Annulé")) {
                        this.setStyle("-fx-text-fill: red;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Disponible")) {
                        this.setStyle("-fx-text-fill: green;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Reporté")) {
                        this.setStyle("-fx-text-fill: yellow;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    } else if (item.equals("Terminé")) {
                        this.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
                    }

                }
            }
        });

        clntitre1.setStyle("-fx-text-fill: blue;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        cptmin1.setStyle("-fx-text-fill: #808080	;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        cptmax1.setStyle("-fx-text-fill: #808080	;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        clnduree1.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        clndate1.setStyle("-fx-text-fill: #808080;-fx-font-weight: bold;-fx-font-style: italic; -fx-alignment: center ; ");
        photo1.setStyle(" -fx-alignment: center ;");

    }

    @FXML
    private void refresh(MouseEvent event) {
        list.clear();
        this.list();
        reservationlst();
    }

    @FXML
    private void deconnexion(ActionEvent event) throws BackingStoreException, IOException {
        UserSession.destroyUserSession();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AccueilEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void connexion(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void inscription(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void gererutilisateur(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("ValidationUser.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gererpublication(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Publication.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void gererreclamation(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("BlockEvent.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
