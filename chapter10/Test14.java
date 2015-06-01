package chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test14 {

	@Test
	public void test() {
		Connection conn=new Connection(new Station("UI"), new Station("Infinite Circle"), "Rumbaugh Line");
		conn.setStatus(false);
		assertEquals(false, conn.getStatus());
	}

}
