package com.msglife.insurance.springboot.crudrestfullwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "vehicle_name")
	private String vehicleName;
	
	@Column(name = "door_number")
	private int doorNumber;
	
	@Column(name = "max_power")
	private int maxPower;
	
	@Column(name = "min_power")
	private int minPower;
	
	
	public Vehicle() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getVehicleName() {
		return vehicleName;
	}
	
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public int getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	public int getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	public int getMinPower() {
		return minPower;
	}
	public void setMinPower(int minPower) {
		this.minPower = minPower;
	}

}
