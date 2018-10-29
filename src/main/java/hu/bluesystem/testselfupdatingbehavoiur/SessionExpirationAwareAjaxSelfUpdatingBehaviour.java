/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bluesystem.testselfupdatingbehavoiur;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.util.time.Duration;

/**
 *
 * @author sfeher
 */
public class SessionExpirationAwareAjaxSelfUpdatingBehaviour extends AjaxSelfUpdatingTimerBehavior {

    public SessionExpirationAwareAjaxSelfUpdatingBehaviour(Duration updateInterval) {
        super(updateInterval);
    }

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
        attributes.getExtraParameters().put("extra","1");
        //updateAjaxAttributes(attributes); //To change body of generated methods, choose Tools | Templates.
    }
    
}
