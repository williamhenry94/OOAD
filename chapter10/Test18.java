package chapter10;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class Test18 {

	

	@Test
	public void test() {
		Station station= new Station("XHTML Expressway");
		assertEquals(true,station.equals(new Station("XHTML Expressway")));
	}

}
