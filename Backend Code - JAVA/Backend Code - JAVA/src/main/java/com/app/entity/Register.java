package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VoterDetail")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fname")
    private String fName;

    @Column(name = "lname")
    private String lName;

    @Column(name = "username", unique = true)
    private String username;
    
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "voter_id_number", unique = true) // Added field for voter ID
    private String voterIdNumber;

    @Column(name = "aadhaar", unique = true) // Added field for Aadhaar number
    private String aadhaar;

    public Register() {
        super();
    }

    public Register(String fName, String lName, String username, String password, String voterIdNumber, String aadhaar) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.voterIdNumber = voterIdNumber;
        this.aadhaar = aadhaar;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVoterIdNumber() {
        return voterIdNumber;
    }

    public void setVoterIdNumber(String voterIdNumber) {
        this.voterIdNumber = voterIdNumber;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
}
