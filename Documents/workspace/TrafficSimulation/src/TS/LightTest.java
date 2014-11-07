package TS;

import junit.framework.TestCase;

public class LightTest extends TestCase {
	Light l = new Light(30, 15);
	Light r = new Light(30, 0);

/**
 * Tests the getPeriod method of the class Light	
 */
	public void testgetPeriod(){
		int a = l.getPeriod();
		assertEquals(30,a);
	}
	
/**
 * Tests the getTime method of the class Light
 */
	public void testgetTime(){
		int b = l.getTime();
		assertEquals(0,b);
	}
	/**
	 * Tests the getGreen metod of the class Light
	 */
	public void testgetGreen(){
		int c = l.getGreen();
		assertEquals(15,c);
		
	}
	/**
	 * Tests the step method of the class Light
	 */
	public void teststep(){
		l.step();
		assertEquals(1,l.getTime());
		
	}
	/**
	 * Tests the isGreen method of the class Light
	 */
	public void testisGreen(){
		boolean dr = r.isGreen();
		boolean d = l.isGreen();
		assertEquals(true, d);
		assertEquals(false, dr);

	}
	/**
	 * Tests the toString method of the class Light
	 */
	
	public void testtoString(){
		String e = l.toString();
		assertEquals("Light(period = 30, green = 15)", e);		
	}
	
}
