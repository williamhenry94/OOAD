package chapter10;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class Test17 {

	

	@Test
	public void test() {
		Connection conn=new Connection(new Station("XHTML Expressway"), new Station("Infinite Circle"), "Rumbaugh Line");
		assertEquals("Rumbaugh Line", conn.getLineName());
	}

}
