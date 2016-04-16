/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nbb.nbdemetra.mairline;

import be.nbb.demetra.mairline.document.MixedAirlineDocument;
import ec.nbdemetra.ws.WorkspaceFactory;
import ec.nbdemetra.ws.WorkspaceItem;
import ec.nbdemetra.ws.ui.WorkspaceTsTopComponent;
import ec.ui.view.tsprocessing.TsProcessingViewer;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//be.nbb.nbdemetra.mairline//MixedAirline//EN",
autostore = false)
@TopComponent.Description(preferredID = "MixedAirlineTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Seasonal Adjustment", id = "be.nbb.nbdemetra.mairline.MixedAirlineTopComponent")
@ActionReference(path = "Menu/Statistical methods/Seasonal Adjustment/Single Analysis", position = 1600)
@TopComponent.OpenActionRegistration(displayName = "#CTL_MixedAirlineAction")
@NbBundle.Messages({
    "CTL_MixedAirlineAction=Mixed Airline",
    "CTL_MixedAirlineTopComponent=Mixed Airline Window",
    "HINT_MixedAirlineTopComponent=This is a Mixed Airline window"
})
public final class MixedAirlineTopComponent extends WorkspaceTsTopComponent<MixedAirlineDocument> {

    private static MixedAirlineDocumentManager manager(){
        return WorkspaceFactory.getInstance().getManager(MixedAirlineDocumentManager.class);
    }

    public MixedAirlineTopComponent() {
        super(manager().create(WorkspaceFactory.getInstance().getActiveWorkspace()));
        initDocument();
    }

    public MixedAirlineTopComponent(WorkspaceItem<MixedAirlineDocument> doc) {
        super(doc);
        initDocument();
    }

    private void initDocument() {
        initComponents();
        setToolTipText(NbBundle.getMessage(MixedAirlineTopComponent.class, "HINT_MixedAirlineTopComponent"));
        setName(getDocument().getDisplayName());
        panel = TsProcessingViewer.create(getDocument().getElement());
        this.add(panel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

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

    @Override
    protected String getContextPath() {
        return MixedAirlineDocumentManager.CONTEXTPATH;
    }
}