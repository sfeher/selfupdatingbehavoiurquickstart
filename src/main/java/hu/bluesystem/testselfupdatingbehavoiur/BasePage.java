package hu.bluesystem.testselfupdatingbehavoiur;

import org.apache.wicket.markup.html.WebPage;

/**
 *
 * @author sfeher
 */
public class BasePage extends WebPage  {

    public BasePage() {
          Populate();
    }

    private void Populate() {
        add(new HeaderPanel("headerpanel"));
        
    }

     
    
}
