package application;

import java.io.Serializable;



public class exercise implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private static int idcounter=1;
	String name;
	String path;
	String desc;
	
	

	public exercise(String name, String path ,String desc ) {
		super();
		this.id = idcounter++;
		this.name = name;
		this.path = path;
		this.desc=desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
		return  name;
	}

	

	
	
	
	

}
