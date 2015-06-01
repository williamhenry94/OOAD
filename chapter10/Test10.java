package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test10 {

	@Test
	public void test() {
		Connection conn= new Connection(new Station("yellow"), new Station("blue"), "yellow-blue");
		assertEquals("blue",conn.getStation2().getName());
	}

}
