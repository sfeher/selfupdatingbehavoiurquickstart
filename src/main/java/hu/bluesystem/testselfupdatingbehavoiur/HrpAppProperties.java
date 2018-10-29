/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bluesystem.testselfupdatingbehavoiur;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sfeher
 */
public class HrpAppProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    private String propKey;
    private String propValue;
    private String propStatus;
    private Date crd;
    private String cru;
    private Date lmd;
    private String lmu;

    public HrpAppProperties() {
    }

    public HrpAppProperties(String propKey) {
        this.propKey = propKey;
    }

    public HrpAppProperties(String propKey, String propValue, Date crd, String cru) {
        this.propKey = propKey;
        this.propValue = propValue;
        this.crd = crd;
        this.cru = cru;
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getPropStatus() {
        return propStatus;
    }

    public void setPropStatus(String propStatus) {
        this.propStatus = propStatus;
    }

    public Date getCrd() {
        return crd;
    }

    public void setCrd(Date crd) {
        this.crd = crd;
    }

    public String getCru() {
        return cru;
    }

    public void setCru(String cru) {
        this.cru = cru;
    }

    public Date getLmd() {
        return lmd;
    }

    public void setLmd(Date lmd) {
        this.lmd = lmd;
    }

    public String getLmu() {
        return lmu;
    }

    public void setLmu(String lmu) {
        this.lmu = lmu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.propKey);
        hash = 17 * hash + Objects.hashCode(this.propValue);
        hash = 17 * hash + Objects.hashCode(this.propStatus);
        hash = 17 * hash + Objects.hashCode(this.crd);
        hash = 17 * hash + Objects.hashCode(this.cru);
        hash = 17 * hash + Objects.hashCode(this.lmd);
        hash = 17 * hash + Objects.hashCode(this.lmu);
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
        final HrpAppProperties other = (HrpAppProperties) obj;
        if (!Objects.equals(this.propKey, other.propKey)) {
            return false;
        }
        if (!Objects.equals(this.propValue, other.propValue)) {
            return false;
        }
        if (!Objects.equals(this.propStatus, other.propStatus)) {
            return false;
        }
        if (!Objects.equals(this.crd, other.crd)) {
            return false;
        }
        if (!Objects.equals(this.cru, other.cru)) {
            return false;
        }
        if (!Objects.equals(this.lmd, other.lmd)) {
            return false;
        }
        if (!Objects.equals(this.lmu, other.lmu)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "hu.bluesystem.hrportal.model.HrpAppProperties[ propKey=" + propKey + " ]";
    }
    
}
