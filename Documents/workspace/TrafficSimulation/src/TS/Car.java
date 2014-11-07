package TS;
public class Car {

	private int bornTime;
	private int dest; // 1 för rakt fram, 2 för vänstersväng
	/**
	 * creates a new Car with given values
	 * @param bornTime what time the car entered the system
	 * @param dest in which direction the car is heading
	 */
	public Car(int bornTime, int dest){
		this.bornTime = bornTime;
		this.dest = dest;
	}
	/**
	 * gives the bornTime of the given car
	 * @return what time the car entered the system
	 */
	public int getbornTime(){
		return this.bornTime;
	}
	/**
	 * gives the destination of the given car
	 * @return in which direction the car is heading
	 */
	public int getdest(){
		return this.dest;
	}

	// konstruktor och get-metoder

	/**
	 * @return the car as a string with its bornTime and destination.
	 */
	public String toString(){
		return "Car(bornTime = " + this.getbornTime() +", dest = " + this.getdest() + ")";
	}
}
