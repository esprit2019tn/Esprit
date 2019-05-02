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
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.sun.javafx.tk.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
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
    private DatePicker date;
    @FXML
    private TextField titre;
    private ComboBox<String> lstsponsor;
    @FXML
    private TextField ville;
    @FXML
    private TextField adresse;
    @FXML
    private Spinner<?> spinner;
    @FXML
    private TextArea description;
    private ImageView img;
    @FXML
    private JFXButton Annuler;
    @FXML
    private JFXButton valider;
    @FXML
    private TextField capacitemax;
    @FXML
    private TextField capacitemin;
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
    private TableColumn<Event, Integer> cptmax;
    @FXML
    private TableColumn<Event, Integer> cptmin;
    @FXML
    private TableColumn<Event, String> clndescri;

    @FXML
    private JFXButton Annuler1;
    @FXML
    private JFXButton Annuler11;

    private boolean nav = false;
    EventDao uda = new EventDao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            VBox vbx = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
            drawer.setSidePane(vbx);

            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(humburger);
            transition.setRate(-1);
            humburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();

                if (drawer.isHidden()) {
                    drawer.open();
                } else {
                    drawer.close();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(CreteEVTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//        public ObservableList<Event> list = FXCollections.observableArrayList(
//                new Event("", "", Long.valueOf(3), Long.valueOf(2), "")
//                );
    public ObservableList<Event> list = FXCollections.observableArrayList();

    public void list() {

        EventDao uda = new EventDao();
        if (list.isEmpty()) {
            list.addAll(uda.findAll());
        }
        clnid.setCellValueFactory(new PropertyValueFactory<Event, Integer>("idEvent"));
        clntitre.setCellValueFactory(new PropertyValueFactory<Event, String>("titre"));
        clndate.setCellValueFactory(new PropertyValueFactory<Event, String>("dateEvent"));
        clnduree.setCellValueFactory(new PropertyValueFactory<Event, Integer>("duree"));
        cptmax.setCellValueFactory(new PropertyValueFactory<Event, Integer>("capaciteMax"));
        cptmin.setCellValueFactory(new PropertyValueFactory<Event, Integer>("capaciteMin"));
        clndescri.setCellValueFactory(new PropertyValueFactory<Event, String>("desc"));

        clntitre.setCellFactory(TextFieldTableCell.forTableColumn());
        clntitre.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
        });
        table.setEditable(true);
        table.setItems(list);

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
            Event evt = new Event(titre.getText(), description.getText(),
                    Long.parseLong(capacitemax.getText()), Long.parseLong(capacitemin.getText()),
                    dt);
//            String h = new SimpleDateFormat("yyyy-MM-dd").format(dts);
//             Date fs = formatter.parse(h);
            System.out.println("---_______i_______-------_" + remove(new Date()));
            uda.insert(evt);
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

    @FXML
    public void choosefile() {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fc.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File fl = fc.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(fl);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            myimg.setImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

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

    public void setDate(DatePicker date) {
        this.date = date;
    }

    public TextField getTitre() {
        return titre;
    }

    public void setTitre(TextField titre) {
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

    public TextField getVille() {
        return ville;
    }

    public void setVille(TextField ville) {
        this.ville = ville;
    }

    public TextField getAdresse() {
        return adresse;
    }

    public void setAdresse(TextField adresse) {
        this.adresse = adresse;
    }

    public Spinner<?> getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner<?> spinner) {
        this.spinner = spinner;
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

    public TextField getCapacitemax() {
        return capacitemax;
    }

    public void setCapacitemax(TextField capacitemax) {
        this.capacitemax = capacitemax;
    }

    public TextField getCapacitemin() {
        return capacitemin;
    }

    public void setCapacitemin(TextField capacitemin) {
        this.capacitemin = capacitemin;
    }

    public boolean isNav() {
        return nav;
    }

    public void setNav(boolean nav) {
        this.nav = nav;
    }

}
