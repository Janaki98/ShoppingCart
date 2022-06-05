//package com.example.mt.model;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "apparal")
//public class Apparal extends Products{
//	
//	private String type;
//	private String brand;
//	private String design;
//	
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "productid")
//	private Products products;
//	
//	public Apparal() {
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getBrand() {
//		return brand;
//	}
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//	public String getDesign() {
//		return design;
//	}
//	public void setDesign(String design) {
//		this.design = design;
//	}
//
//}
