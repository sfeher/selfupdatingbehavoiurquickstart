/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bluesystem.testselfupdatingbehavoiur;

import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author sfeher
 */
public class HeaderPanel extends Panel {
    //implements BreadcrumbListener


    Boolean isSessionExpiring = Boolean.FALSE;
    List<Integer> jvList;
    LoadableDetachableModel jvModel;
    Integer ctsz;
    

    public HeaderPanel(String id) {
        super(id);
        Populate();
    }

    private void Populate() {
        final WebMarkupContainer wmc = new WebMarkupContainer("headercontainer");
        wmc.setOutputMarkupId(true);
        NotificationPanel np = new NotificationPanel("notificationpanel");
        add(np);
        add(wmc);        
    }
}
