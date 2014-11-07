package TS;
public class Lane {

 /*   public static class OverflowException extends RuntimeException{
   
}*/
    private Car[] theLane;
/**
 * Gives a Lane of a given length
 * @param n length of the new Lane
 */
    public Lane(int n) {
	Car theLane[] = new Car [n]; //Array av längden n
	this.theLane = theLane;

	// Konstruerar ett Lane-objekt med plats för n fordon
    }  

 /*   int n = this.theLane.length;
    for (int i = 0; i < n-1; i++;){
	if (this.theLane[i] != null){
	    this.theLane[i]= this.theLane[i+1];
	    this.theLane[i+1] = null;
	}
	    
}

 */
    int full = 0;
    /**
     * Steps every Car in the lane one step forward if the lane's not full.
     * @return 1 if the given lane where full at the time, 0 if not.
     */
    public int step(){
	int j = 0;
	int n = this.theLane.length; 
	while(j < n && this.theLane[j] != null){
	    j++;
	}
	if (j == n){
	    full++;
	}
	else if (this.theLane[j] == null){
		for (int i = j; i<n; i++){
		    if(i == n-1){
			this.theLane[i] = null;
		    }
		    else{
			this.theLane[i] = this.getCar(i+1);
		    }
		} 
	    }
	return full;

	// Stega fram alla fordon (utom det på plats 0) ett steg 
	// (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }
/**
 * Returns the first Car in the lane and then removes it from the lane.
 * @return the first Car
 */
    public Car getFirst() {
	Car a = this.theLane[0];
	this.theLane[0] = null;
	return a;
	// Returnera och tag bort bilen som står först
    }
/**
 * Returns the firts Car in the lane
 * @return the first Car
 */
    public Car firstCar() {
	return this.theLane[0];
	// Returnera bilen som står först utan att ta bort den
    }
    
    /**
     * Returns the Car at the given place in the lane
     * @param n place in the lane
     * @return the Car at place n
     */
    public Car getCar(int n){
	return this.theLane[n];
    }
    /**
     * returns the length of the lane
     * @return the length of the lane
     */
    public int getLength(){
	return this.theLane.length;

}
/**
 * returns true if the last place in the lane is free
 * @return a boolean whether the last place if free or not
 */
    public boolean lastFree() {
	int n = (this.theLane.length - 1);
	if (this.theLane[n] == null){
	    return true;
	}
	return false;
	// Returnera true om sista platsen ledig, annars false
    }
/**
 * Place a given car last in the lane if the place is free
 * @param c the Car that should be placed last
 */
	public void putLast(Car c) /*throws OverflowException*/ {
	    int n = this.theLane.length;
	    if (this.theLane[(n-1)] == null){
		this.theLane[(n-1)] = c;
	       
	    }
	    // Ställ en bil på sista platsen på vägen
	    // (om det går).
	}
    
	//public Car[] getLane(){
	//    return this.theLane;
	//}
/**
 * Returns the lane as a string with every car in the lane as strings.
 * @return the lane as a string
 */
    public String toString() {
	String result = "[";
	int n = this.theLane.length;
	for (int i = 0; i<n; i++){
	    if (this.getCar(i) != null){
		result += this.getCar(i);
		if (i == n-1){    	     
		}
		else if  (this.getCar(i+1) != null){
		    result += ", ";
		}
	    }

	}
	return result + "]";
    }       
	
		    
   
}

