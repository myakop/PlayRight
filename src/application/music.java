package application;

import java.io.Serializable;



public class music implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private static int idcounter=1;
	String name;
	String path;
	
	
	

	public music(String name, String path) {
		super();
		this.id = idcounter++;
		this.name = name;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	

}
