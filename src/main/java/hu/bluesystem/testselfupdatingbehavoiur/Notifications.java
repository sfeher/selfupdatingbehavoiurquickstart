package hu.bluesystem.testselfupdatingbehavoiur;

import java.io.Serializable;

/**
 *
 * @author sfeher
 */
public class Notifications implements Serializable {
    
   Class targetPage;
   String text;
   Long counter;

    public Notifications(Class targetPage, String text, Long counter) {
        this.targetPage = targetPage;
        this.text = text;
        this.counter = counter;
    }

    public Class getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(Class targetPage) {
        this.targetPage = targetPage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.targetPage != null ? this.targetPage.hashCode() : 0);
        hash = 67 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 67 * hash + (this.counter != null ? this.counter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notifications other = (Notifications) obj;
        if (this.targetPage != other.targetPage && (this.targetPage == null || !this.targetPage.equals(other.targetPage))) {
            return false;
        }
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        if (this.counter != other.counter && (this.counter == null || !this.counter.equals(other.counter))) {
            return false;
        }
        return true;
    }
   
   
    
}
