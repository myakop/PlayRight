package application;

import java.io.Serializable;

public class Meal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private static int idcounter=1;
	private String name;
	double carbs;
	double protin;
	double cal;
	
	
	public Meal(String name, double carbs, double cal, double protin) {
		super();
		id=idcounter++;
		this.name = name;
		this.carbs = carbs;
		this.protin = protin;
		this.cal = cal;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static int getIdcounter() {
		return idcounter;
	}
	public static void setIdcounter(int idcounter) {
		Meal.idcounter = idcounter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getProtin() {
		return protin;
	}
	public void setProtin(double protin) {
		this.protin = protin;
	}
	public double getCal() {
		return cal;
	}
	public void setCal(double cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return name+ " have " + carbs+ " carbs," +protin+" protin," +cal+ " calories"  ;
	}
	
	
	
	
	

}
