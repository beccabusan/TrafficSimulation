package TS;

import junit.framework.TestCase;

public class TrafficSystemTest extends TestCase {
	Lane i = new Lane(4); 
	Lane b = new Lane(4);
	Lane c = new Lane(6);
	Light d = new Light(15,3);
	Light e = new Light(15,4);
	Double f = 0.5;
	TrafficSystem t = new TrafficSystem(c,b,i,d,e,f);
	Lane i2 = new Lane(2); 
	Lane b2 = new Lane(2);
	Lane c2 = new Lane(2);
	Light d2 = new Light(15,3);
	Light e2 = new Light(15,4);
	Double f2 = 1.0;
	TrafficSystem t2 = new TrafficSystem(c2,b2,i2,d2,e2,f2);
	Car A = new Car(0,1);
	Car B = new Car(1,1);
	Car C = new Car(2,1);
	Car D = new Car(3,1);
	
/**
 * Tests the GetTime method of class TrafficSystem
 */
	
	public void testGetTime(){
		int g = t.getTime();
		assertEquals(0,g);
	}
	/**
	 * Tests the putCar method of the class TrafficSystem
	 */
	public void testPutCar(){
		t.putCar();
		t2.putCar();
		t2.putCar();
		boolean x = c2.lastFree();
		boolean y = c.lastFree();
		assertEquals(0.5, t.a);
		assertEquals(true, y);
		assertEquals(0.0, t2.a);
		assertEquals(false, x);
	}
	/**
	 * Tests the putCar method of the class TrafficSystem
	 */
	
	public void testMoveCars(){
		i2.putLast(A);
		i2.step();
		i2.putLast(B);
		c2.putLast(C);
		c2.step();
		c2.putLast(D);
		t2.moveCars(c2, i2);
		t.moveCars(c, i);
		assertEquals(true,c.lastFree());
		assertEquals(false, c2.lastFree());
		}
	/**
	 * Tests the CheckLight method of the class TrafficSystem
	 */
	public void testCheckLight(){
		t.checkLight(d,b);
		assertEquals("[]", b.toString());
	}
	/**
	 * Tests the step method of the class TrafficSystem
	 */
	
	public void teststep(){
		t.step();
		t.step();
		t.step();
		assertEquals(true, e.isGreen());
		assertEquals(false, d.isGreen());
		assertEquals(false, c.lastFree());
		assertEquals(1,t.numberOfCars);
	
	}
	/**
	 * Tests the toString method of the class TrafficSystem
	 */
	
	public void testtoString(){
		int n = c.getLength();
		Car h = c.getCar(n-1);
		String s = t.toString();
		assertEquals("TrafficSystem(Lane0: [], Lane1: [], Lane2: [],Light(period = 15, green = 3), Light(period = 15, green = 4), Bilar/sekund: 0.5)",s);
		
	}

}
