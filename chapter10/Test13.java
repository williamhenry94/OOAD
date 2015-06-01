package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test13 {

	@Test
	public void test() {
		Connection conn=new Connection(new Station("UI"), new Station("Infinite Circle"), "Rumbaugh Line");
		assertEquals(true, conn.getStatus());
	}

}
