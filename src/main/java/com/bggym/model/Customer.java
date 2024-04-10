package com.bggym.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

import java.util.Date;

@Entity
@Table(name = "custdetails")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "custno")
    private int custno;

    @Column(name = "custname")
    private String custname;

    @Column(name = "gender")
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "doj", columnDefinition = "DATE")
	private Date doj;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob", columnDefinition = "DATE")
	private Date dob;
    
    @Column(name = "age")
    private int age;

    @Column(name = "packages")
    private String packages;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "bloodgrp")
    private String bloodgrp;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "bmi")
    private Double bmi;

    @Column(name = "phno")
    private String phno;

    @Column(name = "emphno")
    private String emphno;

    @Column(name = "address")
    private String address;

    @Column(name = "registeredby")
    private String registeredby;

    public int getCustno() {
        return custno;
    }

    public void setCustno(int custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getGender() {
        return gender;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    

    public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

  
    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmphno() {
        return emphno;
    }

    public void setEmphno(String emphno) {
        this.emphno = emphno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisteredby() {
        return registeredby;
    }

    public void setRegisteredby(String registeredby) {
        this.registeredby = registeredby;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custno=" + custno + ", custname=" + custname + ", gender=" + gender + ", doj="
				+ doj + ", dob=" + dob + ", age=" + age + ", packages=" + packages + ", occupation=" + occupation
				+ ", bloodgrp=" + bloodgrp + ", height=" + height + ", weight=" + weight + ", bmi=" + bmi + ", phno="
				+ phno + ", emphno=" + emphno + ", address=" + address + ", registeredby=" + registeredby + "]";
	}


    
}
