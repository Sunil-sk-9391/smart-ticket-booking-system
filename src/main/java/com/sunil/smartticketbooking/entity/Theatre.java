package com.sunil.smartticketbooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name="theatres")
public class Theatre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String location;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private int totalScreens;
	
	public Theatre() {
		
	}
	
	
	

	public Theatre(Long id, String name, String location, String address, int totalScreens) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.address = address;
		this.totalScreens = totalScreens;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalScreens() {
		return totalScreens;
	}

	public void setTotalScreens(int totalScreens) {
		this.totalScreens = totalScreens;
	}
	
	
	
	

}
