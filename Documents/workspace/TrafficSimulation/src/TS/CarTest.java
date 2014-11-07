package TS;

import junit.framework.TestCase;

public class CarTest extends TestCase {
	Car b = new Car(4,1);
	Car c = new Car(0,2);
	
	/**
	 * Tests the getDest method of the class Car.
	 */
	public void testDest(){
		int d = b.getdest();
		int e = c.getdest();
		assertEquals(1, d);
		assertEquals(2, e);
		
	}
	/**
	 * Tests the getbornTime method of the class Car.
	 */
		public void testBorntime(){
			int B = b.getbornTime();
			int C = c.getbornTime();
			assertEquals(4,B);
			assertEquals(0,C);
			
		}
		
		/**
		 * Tests the toString method of the class Car.
		 */
		public void testToString(){
			String C = b.toString();
			assertEquals("Car(bornTime = 4, dest = 1)" , C);
		}

}
