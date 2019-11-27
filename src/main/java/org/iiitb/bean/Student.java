package org.iiitb.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true)
    private String rollNumber;
    
    @NotBlank
    private String firstName;
    private String lastName;

    @Column
    @NotBlank
    private Integer admissionYear;
    
    @Column(unique = true)
    private String emailId;

    @ManyToOne
    private Domain domain;// = new Domain();

    @ManyToOne
    private Organization organization; // = new Organization();

    public Student() {
    }
    
    public Student(Integer id) {
        this.id = id;
    }
    
    public Student(String rollNumber, String firstName, String lastName, String emailId, Integer admissionYear, Domain domain) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.admissionYear = admissionYear;
        this.domain = domain;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailId() {
        return emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Domain getDomain() {
        return domain;
    }
    
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
