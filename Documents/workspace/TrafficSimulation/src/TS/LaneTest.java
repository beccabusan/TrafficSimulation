/**
 * 
 */
package TS;

import junit.framework.TestCase;

/**
 * @author Rebecca
 *
 */
public class LaneTest extends TestCase {
	Lane L = new Lane(3);
	Car c = new Car(4,1);
	Lane L2 = new Lane(2);
	Car b = new Car(0,2);
	int n = L.getLength();
	int n2 = L2.getLength();

/**
 * Tests the step method of the class Lane	
 */
public void testStep(){
	L2.putLast(b);
	L2.step();
	L2.putLast(c);
	int f2 = L2.step();
	L.putLast(c);
	int f = L.step();
	Car b = L.getCar(n-2);
	assertEquals(0,f);
	assertEquals(c,b);
	assertEquals(1,f2);
	}

/**
 * Tests the GetFirst method of the class Lane
 */
public void testGetFirst(){
	L2.putLast(b);
	L2.step();
	Car g2 = L2.getFirst();
	Car g = L.getFirst();
	assertEquals(null, g);
	assertEquals(b.getbornTime(), g2.getbornTime());
	assertEquals(b.getdest(), g2.getdest());
	assertEquals("[]", L2.toString());
}

/**
 * Tests the FirstCar method of the class Lane
 */
public void testFirstCar(){
	L2.putLast(b);
	L2.step();
	Car h = L.firstCar();
	Car h2 = L2.firstCar();
	assertEquals(null, h);
	assertEquals("Car(bornTime = 0, dest = 2)", h2.toString() );
	}

/**
 * Tests the GetLength method of the class Lane
 */
public void testGetLength(){
	int i = L.getLength();
	assertEquals(3,i);
	
	}
/**
 * Tests the GetCar method of the class Lane
 */
public void testGetCar(){
	L2.putLast(b);
	Car j2 = L2.getCar(1);
	Car j = L.getCar(2);
	assertEquals(null,j);
	assertEquals("Car(bornTime = 0, dest = 2)",j2.toString());
	}
/**
 * Tests the LastFree method of the class Lane 
 */
public void testLastFree(){
	L2.putLast(b);
	boolean k2 = L2.lastFree();
	boolean k = L.lastFree();
	assertEquals(true, k);
	assertEquals(false, k2);
	}

/**
 * Tests the PutLast method of the class Lane
 */
public void testPutLast(){
	L.putLast(c);
	assertEquals(c, L.getCar(n-1));
}

/**
 * Tests the toString method of the class Lane
 */
public void testToString(){
	String s = L.toString();
	assertEquals("[]", s);
	
}

}
