/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.InteractionDialog;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.esprit.Entity.User;
import com.esprit.Service.ServiceUser;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author AYMEN
 */
public class ValidationUser extends com.codename1.ui.Form {

    public ValidationUser() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
         Menu.getMenu(this);
          ServiceUser serviceUser=new ServiceUser();
          List<User>lst = serviceUser.findUserToValid(); 
    TableModel model = new DefaultTableModel(new String[] {"Nom", "Prenom", "Email"}, new Object[lst.size()][3]);// {
//        public boolean isCellEditable(int row, int col) {
//            return col != 0;
//        }
//    };


          for (int i=0;i<lst.size();i++) {
            model.setValueAt(i, 0, lst.get(i).getNom());
            model.setValueAt(i, 1, lst.get(i).getPrenom());
            model.setValueAt(i, 2, lst.get(i).getEmail());
            
        }

    
    Table table = new Table(model) {
    @Override
    protected Component createCell(Object value, int row, int column, boolean editable) { // (1)
        Component cell= super.createCell(value, row, column, editable);
//        if(row == 1 && column == 1) { // (2)
//            Picker p = new Picker();
//            p.setType(Display.PICKER_TYPE_STRINGS);
//            p.setStrings("Row B can now stretch", "This is a good value", "So Is This", "Better than text field");
//            p.setSelectedString((String)value); // (3)
//            p.setUIID("TableCell");
//            p.addActionListener((e) -> getModel().setValueAt(row, column, p.getSelectedString())); // (4)
//            cell = p;
//        } else {
//            cell = super.createCell(value, row, column, editable);
//        }
        cell.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             //Dialog.show("Dialog Title", "Nom :"+model.getValueAt(row, 2), "ok", "Cancel"){};
             ServiceUser su=new ServiceUser();
             User user=su.findUserByEmail(model.getValueAt(row, 2).toString());
               Dialog dlg = new Dialog("Detail Utilisateur");
               dlg.setLayout(new BorderLayout(CENTER));
               Container conLab = new Container(BoxLayout.y());         
               conLab.add(new Label(user.getNom()));
               conLab.add(new Label(user.getPrenom()));
               conLab.add(new Label(user.getDateNaiss().toString()));
               conLab.add(new Label(user.getSexe()));
               conLab.add(new Label(user.getAdresse()));
               conLab.add(new Label(user.getEmail()));

               Button valider = new Button("Valider");
               Button close = new Button("Close");
               close.addActionListener((ee) -> dlg.dispose());
               valider.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                   ServiceUser.setValidationUser(user.getEmail()); 
                   dlg.dispose();
                   ValidationUser validationUser=new ValidationUser();
                   validationUser.show();
                 }
             });
               
               
                Container com = new Container(BoxLayout.x());         
               com.add(valider);
               com.add(close);
                 dlg.addComponent(BorderLayout.NORTH, conLab);
               dlg.addComponent(BorderLayout.SOUTH, com);
               dlg.show();
            }
        });
        
        if(row > -1 && row % 2 == 0) { // (5)
            // pinstripe effect 
            cell.getAllStyles().setBgColor(0xeeeeee);
            cell.getAllStyles().setBgTransparency(255);
        }
        return cell;
    }
 
    @Override
    protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) {
        TableLayout.Constraint con =  super.createCellConstraint(value, row, column);
        if(row == 1 && column == 1) {
            con.setHorizontalSpan(2);
        }
        con.setWidthPercentage(33);
        return con;
    }
};
    this.add(BorderLayout.CENTER, table);
    }
    
    public ValidationUser(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ValidationUser");
        setName("ValidationUser");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
