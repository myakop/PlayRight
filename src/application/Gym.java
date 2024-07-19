package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;





public class Gym implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Gym gym = null;
	
	private HashMap<Integer, Customer> customers;
	
	private HashMap<Integer, interestedjoin> interestedjoin;
	private HashMap<Integer, Meal>  meals;
	
	private HashMap<Integer, music> music;
	
	
	
	
	
	
	
	 HashMap<Integer, ArrayList<exercise>> mb3;
	 HashMap<Integer, ArrayList<exercise>> mb4;
	 HashMap<Integer, ArrayList<exercise>> mb5;
	 
	 
	 HashMap<Integer, ArrayList<exercise>> wl3;
	 HashMap<Integer, ArrayList<exercise>> wl4;
	 HashMap<Integer, ArrayList<exercise>> wl5;
	 
	
	
	
	
	 ArrayList<Customer> waitingcustomers;
	ArrayList<exercise> Weightlose3daya;
	
	ArrayList<Question> Questions;
	

	public static Gym getInstance()
	{
		
		if(gym == null)
			gym = new Gym();
		
		return gym;
	}
	
	private Gym() {
		
		customers = new HashMap<>();
		interestedjoin = new HashMap<>();
		meals = new HashMap<>();
		music = new HashMap<>();
		
	}
	
	
	
	

	public ArrayList<Customer> getWaitingcustomers() {
		if(waitingcustomers == null) {
			waitingcustomers = new ArrayList<>();
		}
		return waitingcustomers;
	}

	public void setWaitingcustomers(ArrayList<Customer> waitingcustomers) {
		this.waitingcustomers = waitingcustomers;
	}

	public ArrayList<Question> getQuestions() {
		
		if(Questions == null) {
				Questions= new ArrayList<>();
				Main.update();
		}
		return Questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		Questions = questions;
	}

	public ArrayList<exercise> getWeightlose3daya() {
		
		return Weightlose3daya;
	}

	public void setWeightlose3daya(ArrayList<exercise> weightlose3daya) {
		Weightlose3daya = weightlose3daya;
	}

	public HashMap<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<Integer, Customer> customers) {
		this.customers = customers;
	}
	
	public HashMap<Integer, Meal> getMeals() {
		
		return meals;
	}

	public void setMeals(HashMap<Integer, Meal> meals) {
		this.meals = meals;
	}
	public HashMap<Integer, interestedjoin> getinterestedjoin() {
	
		return interestedjoin;
	}

	public void setinterestedjoin(HashMap<Integer, interestedjoin> customers) {
		this.interestedjoin = customers;
	}
	
	public HashMap<Integer, music> getMusic() {
		

		
		
		
	/*	 wl3  = new HashMap<>();
		 wl4 = new HashMap<>() ; 
		 wl5 = new HashMap<>();
		 
		 mb5 = new HashMap<>();
		 
		 
		 ArrayList<exercise> exerciseList = mb5.get(1);
		 if (exerciseList == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList = new ArrayList<>();
		     mb5.put(1, exerciseList);
		 }
		 ArrayList<exercise> exerciseList2 = mb5.get(2);
		 if (exerciseList2 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList2 = new ArrayList<>();
		     mb5.put(2, exerciseList2);
		 }
		 ArrayList<exercise> exerciseList3 = mb5.get(3);
		 if (exerciseList3 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList3 = new ArrayList<>();
		     mb5.put(3, exerciseList3);
		 }
		 ArrayList<exercise> exerciseList4 = mb5.get(4);
		 if (exerciseList4 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList4 = new ArrayList<>();
		     mb5.put(4, exerciseList4);
		 }
		 ArrayList<exercise> exerciseList5 = mb5.get(5);
		 if (exerciseList5 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList5 = new ArrayList<>();
		     mb5.put(5, exerciseList5);
		 }
		 
		 Main.update();  */
		 
		 
		
		
		return music;
	}

	public void setMusic(HashMap<Integer, music> music) {
		this.music = music;
	}
	
	
	public boolean addCustomer(Customer cust) {
		if(cust == null || getCustomers().containsKey(cust.getId()))
			return false;
		
		

  	return getCustomers().put(cust.getId(), cust) ==null;
		
	}
	
    public boolean addinterestedjoin(interestedjoin cust) {
	    
	
		if(cust == null || getinterestedjoin().containsKey(cust.getId())) {
			
			return false;
		}

  	return getinterestedjoin().put(cust.getId(), cust) ==null;
		
	}
    public boolean addnewmeal(Meal meal) {
	    
    	
    		if(meal == null || getMeals().containsKey(meal.getId())) {
    			
    			return false;
    		}

      	return getMeals().put(meal.getId(), meal) ==null;
    		
    	}
    
    public boolean removemeal(Meal meal) {
		if(meal == null || !getMeals().containsKey(meal.getId()))
			return false;
		return getMeals().remove(meal.getId(), meal);
	}
    
    
    public boolean addMusic(music music) {
    	
    	
    	
    	if(music == null || getMusic().containsKey(music.getId())) {
			
			return false;
		}

  	 return getMusic().put(music.getId(), music) ==null;
    	
    }
    
 public boolean addex(exercise ex, String goal , int day) {
	 	 
    	if(goal.equals("mb3")) {
    		
    		mb3.get(day).add(ex);
    	}
    	if(goal.equals("mb4")) {
    		mb4.get(day).add(ex);
    	}
    	if(goal.equals("mb5")) {
    		mb5.get(day).add(ex);
    	}
    	
        if(goal.equals("wl3")) {
    		
    		wl3.get(day).add(ex);
    	}
    	if(goal.equals("wl4")) {
    		wl4.get(day).add(ex);
    	}
    	if(goal.equals("wl5")) {
    		wl5.get(day).add(ex);
    	}
    

  	 return true;
    	
    }
 
 public boolean removeex(exercise ex, String goal ,String plan, int day) {
 	 
 	if(goal.equals("Muscle Building") && plan.equals("3 Days")) {
 		mb3.get(day).remove(ex);
 	}
 	
 	if(goal.equals("mb4") && plan.equals("4 Days")) {
 		mb4.get(day).remove(ex);
 	}
 	if(goal.equals("mb5") && plan.equals("5 Days")) {
 		mb5.get(day).remove(ex);
 	}
 	
     if(goal.equals("wl3")&& plan.equals("3 Days") ) {
 		
 		wl3.get(day).remove(ex);
 	}
 	if(goal.equals("wl4")&& plan.equals("4 Days")) {
 		wl4.get(day).remove(ex);
 	}
 	if(goal.equals("wl5") && plan.equals("5 Days")) {
 		wl5.get(day).remove(ex);
 	}
 

	 return true;
 	
 }
    public boolean removemusic(music music) {
		if(music == null || !getMusic().containsKey(music.getId()))
			return false;
		return getMusic().remove(music.getId(), music);
	}
    
    public boolean addQuestion(Question q) {
  		
  		return getQuestions().add(q);
  	}

}
