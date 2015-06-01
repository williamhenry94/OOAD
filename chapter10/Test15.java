package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class Test15 {

	@Test
	public void test() {
		
        try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			loader.brokeLine("Rumbaugh Line");
			Connection conn=objectville.getConnection(new Station("XHTML Expressway"), new Station("Infinite Circle"));
			assertEquals(false, conn.getStatus());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
      
	}

}
