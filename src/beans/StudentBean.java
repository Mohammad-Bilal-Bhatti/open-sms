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
public class StudentBean extends Bean implements Serializable{
    
    public StudentBean(){}
    
    private Integer studentId;
    private String studentName;
    private String surname;
    private String gender;
    private String guardian;
    private String guardianRelation;
    private String guardianContact;
    private String dob;
    private String studentNic;
    private String contact;
    private String address;
    private String religion;
    private String admissionDate;
    private String nationality;
    private String picturePath;
    private String matricBoard;
    private Integer matricMarks;
    private String matricPassYear;
    private String matricSeatNumber;
    private String interBoard;
    private Integer interMarks;
    private String interPassYear;
    private String interSeatNumber;

    //Instance Initialization Block
    //For setting default values of integer data types
    {
        matricMarks=new Integer(0);
        interMarks=new Integer(0);
        
    }
    
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(String guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStudentNic() {
        return studentNic;
    }

    public void setStudentNic(String studentNic) {
        this.studentNic = studentNic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getMatricBoard() {
        return matricBoard;
    }

    public void setMatricBoard(String matricBoard) {
        this.matricBoard = matricBoard;
    }

    public Integer getMatricMarks() {
        return matricMarks;
    }

    public void setMatricMarks(Integer matricMarks) {
        this.matricMarks = matricMarks;
    }

    public String getMatricPassYear() {
        return matricPassYear;
    }

    public void setMatricPassYear(String matricPassYear) {
        this.matricPassYear = matricPassYear;
    }

    public String getMatricSeatNumber() {
        return matricSeatNumber;
    }

    public void setMatricSeatNumber(String matricSeatNumber) {
        this.matricSeatNumber = matricSeatNumber;
    }

    public String getInterBoard() {
        return interBoard;
    }

    public void setInterBoard(String interBoard) {
        this.interBoard = interBoard;
    }

    public Integer getInterMarks() {
        return interMarks;
    }

    public void setInterMarks(Integer interMarks) {
        this.interMarks = interMarks;
    }

    public String getInterPassYear() {
        return interPassYear;
    }

    public void setInterPassYear(String interPassYear) {
        this.interPassYear = interPassYear;
    }

    public String getInterSeatNumber() {
        return interSeatNumber;
    }

    public void setInterSeatNumber(String interSeatNumber) {
        this.interSeatNumber = interSeatNumber;
    }

    public String getGuardianContact() {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }
}
