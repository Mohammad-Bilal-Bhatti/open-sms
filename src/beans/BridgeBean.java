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
public class BridgeBean extends Bean implements Serializable,Comparable{
    
    public BridgeBean(){}
    
    private Integer bridgeId;
    private StudentBean student;
    private CourseBean course;
    private ShiftBean shift;
    private BatchBean batch;

    public Integer getBridgeId() {
        return bridgeId;
    }

    public void setBridgeId(Integer bridgeId) {
        this.bridgeId = bridgeId;
    }

    public StudentBean getStudent() {
        return student;
    }

    public void setStudent(StudentBean student) {
        this.student = student;
    }

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public ShiftBean getShift() {
        return shift;
    }

    public void setShift(ShiftBean shift) {
        this.shift = shift;
    }

    public BatchBean getBatch() {
        return batch;
    }

    public void setBatch(BatchBean batch) {
        this.batch = batch;
    }

    @Override
    public int compareTo(Object o) {
        BridgeBean bridge=(BridgeBean)o;
        return bridgeId.compareTo(bridge.getBridgeId());
    }
    
    public boolean equals(Object o){
        int decision_value = this.compareTo(o);
        if(decision_value == 0)
            return true;
        return false;                                
    }
    
    public String toString(){
        try{
            String info = course.getCourseName()+", ";
            info+=batch.getBatchName()+", ";
            info+=shift.getShiftName();
        return info;
        }catch(NullPointerException e){
           System.err.println(e.getMessage());
           return super.toString();
        }
    }
}
