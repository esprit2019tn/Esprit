/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.EventDao;
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
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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

    @FXML
    private JFXButton Annuler1;
    @FXML
    private JFXButton Annuler11;
    @FXML
    private TreeTableView<Event> treetable;
    @FXML
    private TreeTableColumn<Event, Integer> col1;

    private boolean nav = false;
    EventDao uda = new EventDao();
    int id;
    int a = 0;
    @FXML
    private TableColumn<Event, ImageView> photo;
    @FXML
    private ListView<String> sponsorlst;

    public ObservableList<String> lstspr = FXCollections.observableArrayList("sp1","sp2","sp3");

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
        sponsorlst.setItems(lstspr);
        sponsorlst.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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

    @FXML
    public void list() {
        Event e = table.getSelectionModel().getSelectedItem();
        EventDao uda = new EventDao();
        if (list.isEmpty()) {
            list.addAll(uda.findAll());
        }
        clnid.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));

        cptmin.setCellValueFactory(new PropertyValueFactory<>("capaciteMin"));
        clndescri.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));
        photo.setCellValueFactory(new PropertyValueFactory<Event, ImageView>("image"));
        //  edittable();
        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
        //  cptmax.setCellFactory(col -> new IntegerEditingCell());
        cptmax.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        cptmin.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

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
        System.out.println("View.CreteEVTController.changename()" + cptmax.getCellObservableValue(row).getValue());
        uda.update(evt);
        list.clear();
        list();
    }

    public void editable(CellEditEvent ce) {
        Event e = table.getSelectionModel().getSelectedItem();
        e.setTitre(ce.getNewValue().toString());
        //  clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
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

}
