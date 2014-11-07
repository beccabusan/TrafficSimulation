package TS;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarTest.class, LaneTest.class, LightTest.class,
		TrafficSystemTest.class })
public class AllTests {

}
