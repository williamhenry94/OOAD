package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test12 {

	@Test
	public void test() {
		Station station=new Station("UI");
		station.setStatus(false);
		assertEquals(false,station.getStatus());
	}

}
