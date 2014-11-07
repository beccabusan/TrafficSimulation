package TS;
public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 
/**
 * Creates a new Light with given parameters
 * @param period the time period the system will run
 * @param green the time period the light shall be green
 */
    public Light(int period, int green) {
	this.period = period;
	this.green  = green;
	this.time = 0;

    }
    /**
     * Returns the period of the light
     * @return the time period the system will run
     */

    public int getPeriod(){
	return this.period;

    }
    /**
     * Returns the time at the moment
     * @return the time of the light
     */
    public int getTime(){
	return this.time;
    }
    
    /**
     * Returns the green period of the light
     * @return the  time period the light shall be green
     */
    
    public int getGreen(){
	return this.green;
    }
    /**
     * Step the time of the Light one step
     */
    public void step() {
	int a = this.getTime();
	this.time = (a + 1);
    }
/**
 * Check wether the light is green at the moment
 * @return true if the light is green, false if not
 */
    public boolean isGreen()  {
	if (this.getTime() < this.getGreen()){
	    return true;
	}
	else if (this.time == (2 * this.getGreen())){
	    this.time = 0;
	    return false;
	}
	else{
	    return false;}
	// Returnerar true om time<green, annars false
    }
   
   /**
    * Gives the light as a string
    * @return the light as a string with the period and the green period
    */
    public String  toString()  {
	return "Light(period = " + this.getPeriod() + "," +  " green = " + this.getGreen() + ")";

}
	
}
