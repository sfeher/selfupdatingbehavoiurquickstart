package hu.bluesystem.testselfupdatingbehavoiur;

import java.util.ArrayList;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

/**
 *
 * @author sfeher
 */
public final class NotificationPanel extends Panel {

    ArrayList<Notifications> nList;
    ArrayList<IModel<Notifications>> mList;

    public NotificationPanel(String id) {
        super(id);
        Populate();
    }

    private void Populate() {
        WebMarkupContainer container = new WebMarkupContainer("container");

        add(container);
        container.setOutputMarkupId(true);
        container.add(new SessionExpirationAwareAjaxSelfUpdatingBehaviour(Duration.seconds(10)));

    }

    public ArrayList<Notifications> getnList() {
        return nList;
    }

    public void setnList(ArrayList<Notifications> nList) {
        this.nList = nList;
    }

}
