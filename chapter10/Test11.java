package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test11 {

	@Test
	public void test() {
		Station station=new Station("UI");
		assertEquals(true,station.getStatus());
	}

}
