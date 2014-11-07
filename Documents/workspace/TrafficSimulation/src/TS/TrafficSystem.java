package TS;

import java.util.Scanner;
import java.util.Random;
import java.lang.*;


public class TrafficSystem {
	// Definierar de vägar och signaler som ingår i det 
	// system som skall studeras.
	// Samlar statistik

	// Attribut som beskriver beståndsdelarna i systemet
	private Lane  r0;
	private Lane  r1;
	private Lane  r2;
	private Light s1;
	private Light s2;
	private double A;
	private Random ran; 

	// Diverse attribut för simuleringsparametrar (ankomstintensiteter,
	// destinationer...)

	// Diverse attribut för statistiksamling  

	private int time = 0;
	/**
	 * Create a new Traffic System with given parameters.
	 * @param r0 the first Lane in the system
	 * @param r1 the straight forward Lane in the system
	 * @param r2 the turning Lane in the system
	 * @param s1 the Light for the straight forward Lane
	 * @param s2 the Light for the turning Lane
	 * @param A the entering car intensity in the system
	 */
	public TrafficSystem(Lane r0, Lane r1, Lane r2, Light s1, Light s2, Double A) {
		this.r0 = r0;
		this.r1 = r1;
		this.r2 = r2;
		this.s1 = s1;
		this.s2 = s2;
		this.A = A;
		this.ran = new Random ();


	}

	/**
	 * Gives the time current time
	 * @return the current time of the system
	 */

	public int getTime(){
		return this.time;
	}

	double a = 0;
	int numberOfCars = 0; 
	int numberOfTurners = 0;
	int numberOfStraight = 0;
	int timeToGoS;
	int timeToGoT;
	int timeMaxS;
	int timeMaxT;
	int full;
	/**
	 * Places a car last i lane r0 if it's, time according to the given intensity.
	 * otherwise adding the intensity number to variable a.
	 */
	public void putCar(){
		if (ran.nextDouble() <= this.A){
			r0.putLast(new Car(this.time, ran.nextInt(2) +1));
			numberOfCars++;
		}
	}

	/**
	 * Moves the first car in the given Lane x into the given Lane y if its possible.
	 * And then puts a new car in the first Lane.
	 * @param x First Lane in the system
	 * @param y Second Lane in the system(either turning or straight forward lane)
	 */
	public void moveCars (Lane x, Lane y){
		if (y.lastFree()){
			y.putLast(x.getFirst());
			int fx = x.step();
			putCar();
		}

		else {
			int fx = x.step();
			if (fx > 0) { 
				full++;
				if (a >= 1){
					a = a-1;
				}

			}
			else {
				putCar();
			}
		}
	}

	/**
	 * Check given light if its green and if so removes the car out of the system and adding one to the variable for number of cars, in either turning och straight forward Lane.
	 * @param s Light for the lane r
	 * @param r the Lane wished to be checked for green light
	 */
	public void checkLight(Light s, Lane r){
		if (s.isGreen()){
			Car b = r.getFirst(); 
			r.step(); 
			if (b != null){
				if(r == r1){
					numberOfStraight++;}
				else{
					numberOfTurners++;}
				timeToGoS += (this.time - b.getbornTime());
				if (timeMaxS < (this.time - (b.getbornTime()))){
					timeMaxS = (this.time - (b.getbornTime()));
				}

			}
		}
		else{
			r.step();
		}

	}
	/**
	 * Stepping the whole system and making sure cars are entering or leaving if needed.
	 */
	public void step() {
		this.time = (this.time +1);
		s1.step();
		s2.step();
		checkLight(s1,r1);
		checkLight(s2,r2);
		if (r0.firstCar() != null && r0.firstCar().getdest() == 1){
			moveCars(r0, r1);
		}

		else if (r0.firstCar() != null && r0.firstCar().getdest() == 2){
			moveCars(r0, r2);

		}
		else {
			//steppa och ev lägg till en ny bil
			r0.step();		
			putCar();

		}

	}

	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna


	public String toString(){
		return "TrafficSystem(Lane0: "   + this.r0 + ", Lane1: " + this.r1 + ", Lane2: " + this.r2 + "," + this.s1 + ", " + this.s2 + ", " + "Bilar/sekund: " + this.A +  ")";

	}

	/**
	 * Prints out the statistics of the running system
	 */

	public void printStatistics() {
		int total = numberOfTurners + numberOfStraight;
		int timeMax = Math.max(timeMaxS, timeMaxT);
		System.out.println("Maximum time:" + timeMax);
		System.out.println("Number of Cars passing through:" + total);
		System.out.println("Number of times the lanes where full:" + full);
		System.out.println("Cars total inside system:"+ numberOfCars);
		if (total != 0){
			int avarage = (timeToGoS + timeToGoT) / (total);
			System.out.println("Avarage time:" + avarage);
		}
		else{System.out.println("No avarage time could be calculated because no car got through");}
		// Skriv statistiken samlad så här långt
	}
	/**
	 * Prints the graphics of the system.
	 */
	public void print() {
		String ls1;
		String ls2;
		String gr1 = "";
		String gr0 = "";
		String gr2 = "";
		int l2 = r2.getLength();
		int l1 = r1.getLength();
		int l0 = r0.getLength();
		for(int i = 0; i < l1; i++){
			if(r1.getCar(i) == null){ 
				gr1 += "--";
			}
			else{
				gr1 += "[]";
			}

		}
		for(int i = 0; i < l2; i++){
			if(r2.getCar(i) == null){ 
				gr2 += "--";
			}
			else{
				gr2 += "[]";
			}
		}
		for(int i = 0; i < l0; i++){
			if(r0.getCar(i) == null){ 
				gr0 += "--";
			}
			else{
				gr0 += "[]";
			}
		}
		if (s1.isGreen()){
			ls1 = "(0)";
		}
		else{
			ls1 = "(x)";
		}
		if(s2.isGreen()){
			ls2 = "(0)";
		}
		else{ 
			ls2 = "(x)";
		}
		System.out.println(ls1 + "  " + gr1 + " " + gr0);
		System.out.println(ls2 + "  " + gr2 + "/" + "\n");
	}
}
/*
 *Totala antalet bilar som åker igenom   x 
 *antalet bilar som kommer in i systemet  x
 *antalet som svänger  x
 *antalet som kör rakt fram x
 *tiden det tar för en bil att åka igenom genomsnitt  (tiden för alla bilar/tot bilar)
 *maximala tiden för en bil att åka igenom
 * tiden för att svänga
 *tiden för att köra rakt fram
 * antalet gånger det blir fullt

 */

/*
2014-11-04
Lyckas inte beräkna antalet gånger det blir fullt. Går alltså inte genom looparna där
variabeln full ökar.

 */
