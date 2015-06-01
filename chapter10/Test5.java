package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Test5 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			Connection x=objectville.getConnection(new Station("XHTML Express"), new Station("Angkot") );
			assertEquals(null, x);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
