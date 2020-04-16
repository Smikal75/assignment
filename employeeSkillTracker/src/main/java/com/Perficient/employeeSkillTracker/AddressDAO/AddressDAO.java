package com.Perficient.employeeSkillTracker.AddressDAO;

public interface AddressDAO {
	//CRUD
	
	public void add (Address newAddress);
	
	public String findAddressId (Address address);
	public Address getAddressById (String addressId);
	
	public void update (Address address);
	
	public void remove (Address address);
}
