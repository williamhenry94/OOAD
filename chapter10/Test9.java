package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test9 {

	@Test
	public void test() {
		Connection conn= new Connection(new Station("yellow"), new Station("blue"), "yellow-blue");
		assertEquals("yellow",conn.getStation1().getName());
	}

}
