/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Javed Ali Dahri
 */
public class FeesTypeBean extends Bean implements Serializable{
    
    public FeesTypeBean(){}
    
    private Integer feesTypeId;
    private String feesTitle;

    public Integer getFeesTypeId() {
        return feesTypeId;
    }

    public void setFeesTypeId(Integer feesTypeId) {
        this.feesTypeId = feesTypeId;
    }

    public String getFeesTitle() {
        return feesTitle;
    }

    public void setFeesTitle(String feesTitle) {
        this.feesTitle = feesTitle;
    }
    
}
