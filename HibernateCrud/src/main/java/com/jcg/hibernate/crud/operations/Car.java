package com.jcg.hibernate.crud.operations;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "CAR", schema = "dbo", catalog = "DBTest")
public class Car implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	private String id;
	private String make;
	private String model;

	public Car() {
	}
	
	public Car(String make, String model) {
		
		this.setMake(make);
		this.setModel(model);
	}

	@GenericGenerator(name = "generator", strategy = "guid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "MAKE", nullable = false)
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "MODEL", nullable = false)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car Details?= Id:" + this.getId() + 
				" Make: " + this.getMake() + 
				" Model: " + this.getModel();
		
	}

}
