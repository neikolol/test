package com.neiko.dao;

public class City {
	private String ID = null;
	private String Name = null;
	private String CountryCode = null;
	private String District = null;
	
	public City() {
		super();
	}
	public City(String iD, String name, String countryCode, String district) {
		super();
		ID = iD;
		Name = name;
		CountryCode = countryCode;
		District = district;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	@Override
	public String toString() {
		return "City [ID=" + ID + ", Name=" + Name + ", CountryCode=" + CountryCode + ", District=" + District + "]";
	}
}
