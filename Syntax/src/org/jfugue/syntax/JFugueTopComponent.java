package org.jfugue.syntax;

import org.musician.api.Score;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.util.Lookup.Result;
import org.openide.util.*;
import org.openide.windows.TopComponent;

@ConvertAsProperties(dtd = "-//org.netbeans.modules.musician//JFugueTopComponent//EN", autostore = false)
@TopComponent.Description(preferredID = "JFugueTopComponent")
@TopComponent.Registration(mode = "properties", openAtStartup = true, position = 20)
@TopComponent.OpenActionRegistration(displayName = "#CTL_JFugueAction")
public final class JFugueTopComponent extends TopComponent implements LookupListener {

    static final String ICON_PATH = "org/netbeans/modules/musician/resources/editor.gif";

    private JFugueTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(JFugueTopComponent.class, "CTL_JFugueTopComponent"));
        setToolTipText(NbBundle.getMessage(JFugueTopComponent.class, "HINT_JFugueTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        edtCommands = new javax.swing.JEditorPane();

        jScrollPane1.setAutoscrolls(true);

        edtCommands.setContentType("audio/midi");
        edtCommands.setEditable(false);
        edtCommands.setEditorKit(edtCommands.getEditorKit());
        jScrollPane1.setViewportView(edtCommands);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JEditorPane edtCommands;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    Result<Score> openScores;

    public void resultChanged(LookupEvent le) {
//        JOptionPane.showMessageDialog(null, "change...");
        if (!openScores.allInstances().isEmpty()) {
//            for (Score s : openScores.allInstances()) {
            Score s = openScores.allInstances().iterator().next();
                setDisplayName(s.getTitle());
                displayScore(s);
//            }
        }
    }

    @Override
    public void componentOpened() {
//        openScores = CentralLookup.getDefault().lookupResult(Score.class);
        openScores = Utilities.actionsGlobalContext().lookupResult(Score.class);
//        openScores = WindowManager.getDefault().findTopComponent("ScoreTopComponent").getLookup().lookupResult(Score.class);
        openScores.addLookupListener(this);
        
        
    }

    @Override
    protected void componentClosed() {
        openScores.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public void displayScore(Score s) {
        edtCommands.setText(s.toString());
        int l = edtCommands.getText().length();
        edtCommands.setCaretPosition(l);
    }

    public String getContent() {
        return edtCommands.getText();
    }

    public void setContent(String s) {
        edtCommands.setText(s);
    }
}
