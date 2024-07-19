package application;

import java.io.Serializable;

public class interestedjoin extends Person implements Serializable {
	
	
	
	
	private static final long serialVersionUID = 1L;
	private static int idCounter = 1;
	private String fullname;
	private String phone;
	private String area;
	
	
	
	public interestedjoin(String fullname,String phone, String area) {
		super(idCounter++, Main.saveCustomer.getFirstName(), Main.saveCustomer.getLastName(), Main.saveCustomer.getBirthDay(), Main.saveCustomer.getGender());
		this.fullname = fullname;
		this.phone = phone;
		this.area=area;
		
	}

	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPhone() {
		return phone;
	}
	
	public interestedjoin(int id) {
		super(id);
	}
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		interestedjoin.idCounter = idCounter;
	}
	


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}
	
	
	


	@Override
	public String toString() {
		return  fullname + " from " + area + " Contact: " + phone   ;
	}
	

}
