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
public class FeesBean extends Bean implements Serializable{
    
    public FeesBean(){}
    
    private Integer feesId;
    private FeesTypeBean feesType;
    private BridgeBean bridgeId;
    private Double feesAmount;
    private String dateOfPayment;
    private Integer numOfMonths;
    private Double totalFeesAmount;

    public Double getTotalFeesAmount() {
        return totalFeesAmount;
    }

    public void setTotalFeesAmount(Double totalFeesAmount) {
        this.totalFeesAmount = totalFeesAmount;
    }

    public Integer getFeesId() {
        return feesId;
    }

    public void setFeesId(Integer feesId) {
        this.feesId = feesId;
    }

    public FeesTypeBean getFeesType() {
        return feesType;
    }

    public void setFeesType(FeesTypeBean feesType) {
        this.feesType = feesType;
    }

    public Double getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(Double feesAmount) {
        this.feesAmount = feesAmount;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Integer getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(Integer numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public BridgeBean getBridgeId() {
        return bridgeId;
    }

    public void setBridgeId(BridgeBean bridgeId) {
        this.bridgeId = bridgeId;
    }
    
}
