/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.esprit.Metier.EmailSend;

/**
 * GUI builder created Form
 *
 * @author dhiae
 */
public class BlockReclamation extends com.codename1.ui.Form {

    public BlockReclamation() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        
    }
    
    public BlockReclamation(com.codename1.ui.util.Resources resourceObjectInstance) {
                this.getToolbar().addCommandToOverflowMenu("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ListReclamation listr = new ListReclamation();
                listr.getF().show();
            }
        });
        initGuiBuilderComponents(resourceObjectInstance);
        gui_LabelEvt.setText("Réclamation de l'événement : "+ListReclamation.getRecStatic().getEvent().getTitre());
        gui_LabelNomUser.setText("Utilisateur : " +ListReclamation.recStatic.getUser().getNom()+ " " + ListReclamation.recStatic.getUser().getPrenom());
        gui_LabelSujet.setText("Sujet de la Réclamation : " +ListReclamation.recStatic.getSujetReclam());
        gui_LabelText.setText("Explication : " +ListReclamation.recStatic.getTextReclam());
        gui_LabelDate.setText("Date de réclamation : " +ListReclamation.recStatic.getDateReclam());
        
    }

    public void onBlockervtActionEvent(com.codename1.ui.events.ActionEvent ev)
    {
        
     EmailSend.sendRepReclamation(ListReclamation.recStatic.getUser().getEmail(), ListReclamation.recStatic.getEvent());

        
        
    }
//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_LabelEvt = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LabelNomUser = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LabelSujet = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LabelText = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LabelDate = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Blockervt = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Ev\u00E8nement r\u00E9clam\u00E9e");
        setName("BlockReclamation");
        gui_LabelEvt.setPreferredSizeStr("187.30159mm 8.201058mm");
        gui_LabelEvt.setText("LabelEvt");
                gui_LabelEvt.setInlineStylesTheme(resourceObjectInstance);
        gui_LabelEvt.setInlineAllStyles("fgColor:b300b3;");
        gui_LabelEvt.setName("LabelEvt");
        gui_LabelNomUser.setPreferredSizeStr("185.97884mm 10.05291mm");
        gui_LabelNomUser.setText("LabelNomUser");
                gui_LabelNomUser.setInlineStylesTheme(resourceObjectInstance);
        gui_LabelNomUser.setInlineAllStyles("fgColor:b300b3;");
        gui_LabelNomUser.setName("LabelNomUser");
        gui_LabelSujet.setPreferredSizeStr("188.35979mm inherit");
        gui_LabelSujet.setText("LabelSuejt");
                gui_LabelSujet.setInlineStylesTheme(resourceObjectInstance);
        gui_LabelSujet.setInlineAllStyles("fgColor:b300b3;");
        gui_LabelSujet.setName("LabelSujet");
        gui_LabelText.setPreferredSizeStr("188.35979mm 30.42328mm");
        gui_LabelText.setText("LabelText");
                gui_LabelText.setInlineStylesTheme(resourceObjectInstance);
        gui_LabelText.setInlineAllStyles("fgColor:b300b3;");
        gui_LabelText.setName("LabelText");
        gui_LabelDate.setPreferredSizeStr("187.30159mm inherit");
        gui_LabelDate.setText("LabelDate");
                gui_LabelDate.setInlineStylesTheme(resourceObjectInstance);
        gui_LabelDate.setInlineAllStyles("fgColor:b300b3;");
        gui_LabelDate.setName("LabelDate");
        gui_Blockervt.setPreferredSizeStr("187.30159mm inherit");
        gui_Blockervt.setText("Bloquer cette \u00E9v\u00E8nement");
                gui_Blockervt.setInlineStylesTheme(resourceObjectInstance);
        gui_Blockervt.setName("Blockervt");
        addComponent(gui_LabelEvt);
        addComponent(gui_LabelNomUser);
        addComponent(gui_LabelSujet);
        addComponent(gui_LabelText);
        addComponent(gui_LabelDate);
        addComponent(gui_Blockervt);
        ((com.codename1.ui.layouts.LayeredLayout)gui_LabelEvt.getParent().getLayout()).setInsets(gui_LabelEvt, "2.1164021mm 0.0mm auto 1.0582047mm").setReferenceComponents(gui_LabelEvt, "-1 -1 -1 -1").setReferencePositions(gui_LabelEvt, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LabelNomUser.getParent().getLayout()).setInsets(gui_LabelNomUser, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LabelNomUser, "0 0 -1 0 ").setReferencePositions(gui_LabelNomUser, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LabelSujet.getParent().getLayout()).setInsets(gui_LabelSujet, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LabelSujet, "1 -1 -1 0 ").setReferencePositions(gui_LabelSujet, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LabelText.getParent().getLayout()).setInsets(gui_LabelText, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LabelText, "4 0 -1 0 ").setReferencePositions(gui_LabelText, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LabelDate.getParent().getLayout()).setInsets(gui_LabelDate, "22.243345% 0.0mm auto 3.5762787E-6mm").setReferenceComponents(gui_LabelDate, "-1 -1 -1 0 ").setReferencePositions(gui_LabelDate, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Blockervt.getParent().getLayout()).setInsets(gui_Blockervt, "auto 0.0mm 18.631178% 3.5762787E-6mm").setReferenceComponents(gui_Blockervt, "-1 -1 -1 0 ").setReferencePositions(gui_Blockervt, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
}
