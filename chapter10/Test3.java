package chapter10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Test3 {

	@Test
	public void test() {
		try {
        	SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:/william/workspace/Subway/src/chapter10/ObjectvilleSubway.txt"));
			boolean x=objectville.addStation("XHTML Expressway");
			assertEquals(false, x);
			boolean y=objectville.addStation("XHTML");
			assertEquals(true, y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
